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

import com.example.miniProjet.entities.Departement;
import com.example.miniProjet.service.DepartementService;
import com.example.miniProjet.service.EntrepriseService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/departements")
public class DepartementController {
	@Autowired
	DepartementService departementService;
	@Autowired
	EntrepriseService entrepriseService;
	
    @PostMapping("/addDepartement")
	public void addDepartement(@RequestBody Departement dep) {
		departementService.addDepartement(dep);
	}
    @PutMapping("/updateDepartement/{id}")
	public Departement updateDepartement(@RequestBody Departement dep, @PathVariable (value="id") int id) {
		return departementService.updateDepartement(dep, id);
	}
    @DeleteMapping("/deleteDepartement/{id}")
	public String deleteDepartement(@PathVariable (value="id") int dep) {
		return departementService.deleteDepartement(dep);
	}
    @GetMapping("/getDepartement/{id}")
	public Departement getDepartement(@PathVariable (value="id") int dep) {
		return departementService.getDepartement(dep);
	}
    
	public List<Departement> getAllDepartement() {
		return departementService.getAllDepartement();
	}
	
	@GetMapping("/affectDepartementEntreprise/{idDept}/{idEnt}")
	public void affectDeptToEnt(@PathVariable (value="idDept") int idDept,@PathVariable (value="idEnt") int idEnt) {
		departementService.affectDeptToEnt(idDept, idEnt);
	}
	

}
