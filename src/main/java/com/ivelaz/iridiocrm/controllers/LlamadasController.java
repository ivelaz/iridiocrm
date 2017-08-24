package com.ivelaz.iridiocrm.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.entities.Llamada;
import com.ivelaz.iridiocrm.services.ClienteService;

@Controller
@RequestMapping("/llamadas")
public class LlamadasController {
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	ClienteService clienteService;
	
	@GetMapping("/nuevallamada")
	public ModelAndView llamadaForm(@RequestParam(name="id", required=true) Integer id) {	
		Llamada llamada = new Llamada();
		llamada.setCliente(clienteService.buscarClientePorId(id));
		llamada.setFecha(new Date());
		ModelAndView mav = new ModelAndView(ConstantesVistas.LLAMADAS_FORM);
		mav.addObject("llamada", llamada);
		mav.addObject("titulo", "Registrar nueva llamada");
		return mav;
	}
	
	
	// @GetMapping("/listarllamadas") CON REQUESTPARAM: "id"

}
