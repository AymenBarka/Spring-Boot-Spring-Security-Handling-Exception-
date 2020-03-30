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

import com.example.miniProjet.entities.Entreprise;
import com.example.miniProjet.service.EntrepriseService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/entreprises")

public class EntrepriseController {
@Autowired
EntrepriseService entrepriseService;

@PostMapping("/addEntreprise")
public void addEntreprise(@RequestBody Entreprise ent) {
	entrepriseService.addEntreprise(ent);
}
@PutMapping("/updateEntreprise")
public Entreprise updateEntreprise(@RequestBody Entreprise ent, @PathVariable (value="id") int id) {
	return entrepriseService.updateEntreprise(ent, id);
}
@DeleteMapping("/deleteEntreprise")
public String deleteEntreprise(@PathVariable (value="id") int ent) {
	return entrepriseService.deleteEntreprise(ent);
}
@GetMapping("/getEntreprise/{id}")
public Entreprise getEntreprise(@PathVariable (value="id") int ent) {
	return entrepriseService.getEntreprise(ent);
}

public List<Entreprise> getAllEntreprise() {
	return entrepriseService.getAllEntreprise();
}

}
