package br.edu.ifpb.pweb2.caderneta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String getIndex() {
		return "home";
	}


}
