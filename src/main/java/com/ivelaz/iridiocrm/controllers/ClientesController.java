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
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.models.ClienteModel;
import com.ivelaz.iridiocrm.services.ClienteService;


@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	private static final Log LOG = LogFactory.getLog(ClientesController.class);
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	

	@GetMapping("/crearcliente")
	public ModelAndView mostrarFormulario() {
		ModelAndView mav = new ModelAndView(ConstantesVistas.CLIENTES_FORM);
		ClienteModel cliente = new ClienteModel();
		cliente.setTipoCliente("Particular");
		mav.addObject("cliente", cliente);
		return mav;
	}
	

	@PostMapping("/addCliente")
	public String addCliente(@Valid @ModelAttribute(name="cliente") ClienteModel cliente, 
												BindingResult bindingResult, Model model) {		
							
		if(bindingResult.hasErrors()) {
			return ConstantesVistas.CLIENTES_FORM;			
		} else {
			LOG.info("Método: addCliente() -- Parámetro: cliente: " + cliente.toString());
			if(null != clienteService.addCliente(cliente)) {	// Si se guarda correctamente en BD
				model.addAttribute("result", 1);
			} else {
				model.addAttribute("result", 0);
			}
			model.addAttribute("pruebaresult", "prueba propagación");	// ELIMINAR: para probar los results sin error
		}
				
		return ConstantesVistas.CLIENTES_FORM;		// CAMBIAR A: "redirect:/clientes/showclientes"
		
	}
	
}
