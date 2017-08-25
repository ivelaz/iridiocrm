package com.ivelaz.iridiocrm.controllers;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ivelaz.iridiocrm.constants.ConstantesVistas;
import com.ivelaz.iridiocrm.models.ClienteModel;
import com.ivelaz.iridiocrm.models.LlamadaModel;
import com.ivelaz.iridiocrm.services.ClienteService;
import com.ivelaz.iridiocrm.services.LlamadaService;

@Controller
@RequestMapping("/llamadas")
public class LlamadasController {
	
	private static final Log LOG = LogFactory.getLog(LlamadasController.class);
	
	@Autowired
	@Qualifier("clienteServiceImpl")
	private ClienteService clienteService;
	
	@Autowired
	@Qualifier("llamadaServiceImpl")
	private LlamadaService llamadaService;
	
	@GetMapping("/nuevallamada")
	public ModelAndView llamadaForm(@RequestParam(name="id", required=true) Integer id) {			
		
		ModelAndView mav = new ModelAndView(ConstantesVistas.LLAMADAS_FORM);
		LOG.info("Método llamadaForm() Parámetro id=" + id);
		ClienteModel cliente = clienteService.buscarClienteModelPorId(id);
		LlamadaModel llamada = new LlamadaModel();
		llamada.setCliente(cliente);
		llamada.setFecha(new Date());
		llamada.setTipo("Recibida");
		llamada.setTelefono(cliente.getTelefono());
		
		mav.addObject("llamada", llamada);
		//mav.addObject("cliente", cliente);
		mav.addObject("titulo", "Registrar nueva llamada");
		LOG.info("Método llamadaForm() Antes de return");
		return mav;
	}
	
	
	// @GetMapping("/listarllamadas") CON REQUESTPARAM: "id"
	
	// @PostMapping("/addllamada")@Valid @ModelAttribute(name.....

}
