package com.ivelaz.iridiocrm.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.models.ClienteModel;



/**
 * Mapea las URLs de operaciones relacionadas con
 * clientes.
 */
@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	private static final Log LOG = LogFactory.getLog(ClientesController.class);
	
	/**
	 * Mostrar formulario.
	 * URL: localhost:8080/clientes/crearcliente
	 * @return un ModelAndView con la vista y un 
	 * ClienteModel vacío para utilizarlo en el formulario.
	 */
	@GetMapping("/crearcliente")
	public ModelAndView mostrarFormulario() {
		ModelAndView mav = new ModelAndView(ConstantesVistas.CLIENTES_FORM);
		ClienteModel cliente = new ClienteModel();
		mav.addObject("cliente", cliente);
		return mav;
	}
	
	/**
	 * Procesa el formulario crear Cliente.
	 * URL: localhost:8080/clientes/addCliente
	 * @param cliente el objeto devuelto relleno por el formulario.
	 * @return la vista.
	 */
	@PostMapping("/addCliente")
	public String addCliente(@ModelAttribute(name="cliente") ClienteModel cliente) {
		LOG.info("Método: addCliente() -- Parámetro: " + cliente.toString());		
		return "redirect:/clientes/crearcliente";
		
	}
	
}
