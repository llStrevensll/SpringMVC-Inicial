package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//return "redirect:/app/index";//redirige y po ello cambia la ruta en el navegador
		return "forward:/app/index"; //no cambia la ruta url del navegador(solo usa rutas propias del proyecto)
	}

}
