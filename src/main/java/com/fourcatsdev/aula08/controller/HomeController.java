package com.fourcatsdev.aula08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/") 
	public String index(Model model) {
		model.addAttribute("msnBemVindo", "Bem-vindo ao sistema de registro de ocorrências criminais da Guiné-Bissau");
		return  "publica-index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}




}
