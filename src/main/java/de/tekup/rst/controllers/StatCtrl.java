package de.tekup.rst.controllers;

import org.springframework.web.bind.annotation.*;

import de.tekup.rst.services.StatService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StatCtrl {
	
	private StatService statService;
	
	@GetMapping("/api/stats/client/jour/{id}")
	public String clientJour(@PathVariable int id) {
		return statService.clientJour(id);
	}

}
