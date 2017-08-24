package com.ivelaz.iridiocrm.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.entities.Cliente;
import com.ivelaz.iridiocrm.entities.Llamada;
import com.ivelaz.iridiocrm.models.Busqueda;
import com.ivelaz.iridiocrm.models.ClienteModel;
import com.ivelaz.iridiocrm.services.ClienteService;
import com.ivelaz.iridiocrm.services.LlamadaService;

@Controller
@RequestMapping("/buscar")
public class BusquedasController {
	
	private static final Log LOG = LogFactory.getLog(BusquedasController.class);

	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	@Autowired
	@Qualifier("llamadaServiceImpl")
	private LlamadaService llamadaService;
	
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
		
		List<ClienteModel> lista = new ArrayList<ClienteModel>();
		
		switch(busqueda.getTipoBusqueda()) {
		    case "id":
				String palabra = busqueda.getPalabraClave();
				palabra.replaceAll(" ", "");
				try {
					int id = Integer.parseInt(palabra);					
							if(clienteService.buscarClienteModelPorId(id) != null) {
								lista.add(clienteService.buscarClienteModelPorId(id));
							} else {
								model.addAttribute("sinresultados", true);
							}					
					model.addAttribute("resultados", lista);
					return ConstantesVistas.RESULTADOS;
				} catch (Exception ex) {
					model.addAttribute("titulo", "Error en número de cliente");
					model.addAttribute("errorid", 1);
					return ConstantesVistas.BUSCAR_FORM;
				}	
	            
			case "nombre":
				lista = clienteService.buscarPorNombre(busqueda.getPalabraClave());
				if(lista.isEmpty()) { model.addAttribute("sinresultados", true); }
				model.addAttribute("resultados", lista);
				return ConstantesVistas.RESULTADOS;
			    
			case "dni":
				lista = clienteService.buscarPorDni(busqueda.getPalabraClave());
				if(lista.isEmpty()) { model.addAttribute("sinresultados", true); }
				model.addAttribute("resultados", lista);
				return ConstantesVistas.RESULTADOS;
				
			case "telefono":
				lista = clienteService.buscarPorTelefono(busqueda.getPalabraClave());
				if(lista.isEmpty()) { model.addAttribute("sinresultados", true); }
				model.addAttribute("resultados", lista);
				return ConstantesVistas.RESULTADOS;
				
			default:
				LOG.info("Método buscarcliente() error: Tipo de búsqueda erróneo.");
				model.addAttribute("titulo", "Error en palabra clave o número");
				return ConstantesVistas.BUSCAR_FORM;
		}
	
	}

	@GetMapping("/probar")
	public String probar() {
		Llamada llamada = new Llamada(clienteService.buscarClientePorId(1), 
				new Date(), "Recibida", "900000000", "el pollo llama", "notas de la llamada del pollo");
		Llamada guardada = llamadaService.addLlamada(llamada);
		Cliente cliente = clienteService.buscarClientePorId(1);
		System.out.println(cliente.getLlamadas().get(1).getAsunto());
		System.out.println("tamaño " + cliente.getLlamadas().size());
		return guardada.getTelefono();
	}
	
	
	
}
