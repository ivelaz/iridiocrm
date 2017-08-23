package com.ivelaz.iridiocrm.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.models.Busqueda;
import com.ivelaz.iridiocrm.services.ClienteService;

@Controller
@RequestMapping("/buscar")
public class BusquedasController {
	
	private static final Log LOG = LogFactory.getLog(BusquedasController.class);

	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	@GetMapping("/buscarform")
	public ModelAndView buscarForm() {
		ModelAndView mav = new ModelAndView(ConstantesVistas.BUSCAR_FORM);
		Busqueda busqueda = new Busqueda();		
		busqueda.setTipoBusqueda("nombre");
		mav.addObject("busqueda", busqueda);
		mav.addObject("titulo", "LLamadas: Buscar cliente");
		return mav;
	}
	
	@PostMapping("/buscarcliente")
	public String buscarCliente(@Valid @ModelAttribute(name="busqueda") Busqueda busqueda,
			BindingResult bindingResult, Model model){
		
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("titulo", "Error en palabra clave o número");
			return ConstantesVistas.BUSCAR_FORM;
		}		
		
		switch(busqueda.getTipoBusqueda()) {
		    case "id":
				String palabra = busqueda.getPalabraClave();
				palabra.replaceAll(" ", "");
				try {
					int id = Integer.parseInt(palabra);
					model.addAttribute("resultados", clienteService.buscarClienteModelPorId(id));
					return ConstantesVistas.RESULTADOS;
				} catch (Exception ex) {
					model.addAttribute("titulo", "Error en número de cliente");
					model.addAttribute("errorid", 1);
					return ConstantesVistas.BUSCAR_FORM;
				}	
	            
			case "nombre":
				model.addAttribute("resultados", clienteService.buscarPorNombre(busqueda.getPalabraClave()));
				return ConstantesVistas.RESULTADOS;
			    
			case "dni":
				model.addAttribute("resultados", clienteService.buscarPorDni(busqueda.getPalabraClave()));
				return ConstantesVistas.RESULTADOS;
				
			case "telefono":
				model.addAttribute("resultados", clienteService.buscarPorTelefono(busqueda.getPalabraClave()));
				return ConstantesVistas.RESULTADOS;
				
			default:
				LOG.info("Método buscarcliente() error: Tipo de búsqueda erróneo.");
				model.addAttribute("titulo", "Error en palabra clave o número");
				return ConstantesVistas.BUSCAR_FORM;
		}
	
	}

	
	
	
	
}
