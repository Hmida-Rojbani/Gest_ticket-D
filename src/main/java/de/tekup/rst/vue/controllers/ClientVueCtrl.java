package de.tekup.rst.vue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientVueCtrl {
 
	@GetMapping("/clients/show")
	public String getClientShow() {
		return "clients/show-clients";
	}
}
