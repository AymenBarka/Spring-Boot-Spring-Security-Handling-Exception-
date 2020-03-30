package com.example.miniProjet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniProjet.entities.Contrat;
import com.example.miniProjet.service.ContratService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/contrats")
public class ContratController {

	@Autowired
	ContratService contratService;
    
	@PostMapping("/addContrat")
	public void addContrat(@RequestBody Contrat crt) {
		contratService.addContrat(crt);
	}
    @PutMapping("/updateContrat/{id}")
	public Contrat updateContrat(@RequestBody Contrat crt, @PathVariable (value= "id") int id) {
		return contratService.updateContrat(crt, id);
	}
    @DeleteMapping("/deleteContrat")
	public String deleteContrat(@PathVariable (value="id") int crt) {
		return contratService.deleteContrat(crt);
	}
    @GetMapping("/getContrat/{id}")
	public Contrat getContrat(@PathVariable (value ="id") int crt) {
		return contratService.getContrat(crt);
	}

	public List<Contrat> getAllContrat() {
		return contratService.getAllContrat();
	}
	
}
