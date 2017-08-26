package com.ivelaz.iridiocrm.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String fechaStr = sdf.format(new Date());
		llamada.setFecha(fechaStr);
		llamada.setCliente(cliente.getId());		
		llamada.setTipo("Recibida");
		llamada.setTelefono(cliente.getTelefono());			
		mav.addObject("fechastr", fechaStr);		
		mav.addObject("llamada", llamada);		
		mav.addObject("titulo", "Registrar nueva llamada");
		
		return mav;
	}
	
	@PostMapping("/addllamada")
	public String addLlamada(@Valid @ModelAttribute(name="llamada") LlamadaModel llamadaModel,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("titulo", "Datos erróneos");
			return ConstantesVistas.LLAMADAS_FORM;
		} else {
			return "redirect:http://www.google.es";
		}
		
		//return null;
	}
	
	// @GetMapping("/listarllamadas") CON REQUESTPARAM: "id"

}
