package pe.edu.delfines.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.services.ClienteService;



@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cliente> clientes= clienteService.findAll();
			model.addAttribute("clientes",clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				
				model.addAttribute("cliente", optional.get());
			}else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("cliente") Cliente cliente,Model model, SessionStatus status) {
		
		try {
			
			clienteService.save(cliente);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente";
	}
	
	@PostMapping("/saveedit")
	public String saveedit(@ModelAttribute("cliente") Cliente cliente,Model model, SessionStatus status) {
		
		try {
			
			clienteService.save(cliente);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente";
	}
	
	
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente",cliente);
		return "/cliente/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Cliente> cliente= clienteService.findById(id);
			if(cliente.isPresent()) {
				clienteService.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("dangerDel","ERROR");
			try {
				List<Cliente> clientes = clienteService.findAll();
				model.addAttribute("clientes",clientes);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "/clientes/inicio";
		}
		return "redirect:/cliente";
	}
	@GetMapping("/info/{id}")
	public String info (@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Cliente> cliente = clienteService.findById(id);
			if(cliente.isPresent()) {
				model.addAttribute("cliente",cliente.get());
			}else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/info";
	}
}
