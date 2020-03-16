package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		//map.put("titulo", "hola Spring Framework!");
		//mv.addObject("titulo", "Hola Spring Framework con Model and View");
		//mv.setViewName("index");
		return "index";
	}
	
	@RequestMapping("/perfil")  //sino se indica por defecto es get
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Angel");
		usuario.setApellido("Rodriguez");
		usuario.setEmail("correo@email.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = Arrays.asList(new Usuario("Angel" , "Rodriguez", "correo@email.com"),
				new Usuario("Emanuel", "Rodriguez", "correo1@email.com"),
				new Usuario("Steven", "Rodriguez", "correo2@email.com"),
				new Usuario("Strevens", "Full", "correo3@email.com"));
		

		model.addAttribute("titulo", textoListar);
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
	//Usar model Attribute cuando se quiera compartir de manera general en varias vistas del controlador
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = Arrays.asList(new Usuario("Angel" , "Rodriguez", "correo@email.com"),
				new Usuario("Emanuel", "Rodriguez", "correo1@email.com"),
				new Usuario("Steven", "Rodriguez", "correo2@email.com"),
				new Usuario("Strevens", "Full", "correo3@email.com"));
		
		return usuarios;
	}
}
