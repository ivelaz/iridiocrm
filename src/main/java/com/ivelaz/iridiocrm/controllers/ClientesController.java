package com.ivelaz.iridiocrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientesController {
	
	@GetMapping("/crearcliente")
	public ModelAndView mostrarFormulario() {
		ModelAndView mav = new ModelAndView("clientesform");
		return mav;
	}
	
}
