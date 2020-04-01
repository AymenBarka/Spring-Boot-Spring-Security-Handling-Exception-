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

import com.example.miniProjet.entities.Employe;
import com.example.miniProjet.service.DepartementService;
import com.example.miniProjet.service.EmployeService;
import com.example.miniProjet.service.MissionService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/employees")
public class EmployeController {
	@Autowired 
	EmployeService employeService ;
	@Autowired
	MissionService missionService;
	@Autowired
	DepartementService departementService;


@PutMapping("/updateEmploye/{id}")
	public Employe updateEmploye(@RequestBody Employe em, @PathVariable (value="id") int id) {
		return employeService.updateEmploye(em , id);
	}
@DeleteMapping("/deleteEmploye/{id}")
	public String deleteEmploye(@PathVariable (value = "id") int em) {
		return employeService.deleteEmploye(em);
	}
@GetMapping("/getEmploye/{id}")
	public Employe getEmploye(@PathVariable (value = "id") int em) {
		return employeService.getEmploye(em);
	}
@GetMapping("/getEmploye")
	public List<Employe> getAllEmploye() {
		return employeService.getAllEmploye();
	}
@GetMapping("/affectEmployeToDepartement/{idEmp}/{idDept}")
	public void affectEmpToDept(@PathVariable (value="idEmp" ) int idEmp, @PathVariable (value="idDept") int idDept) {
		employeService.affectEmpToDept(idEmp, idDept);
	}
@GetMapping("/affectMissonToEmploye/{idEmp}/{idMiss}")
public void affectEmpToMiss(@PathVariable (value="idEmp" ) int idEmp, @PathVariable (value= "idMiss") int idMiss) {
	employeService.affectEmpToMiss(idEmp, idMiss);
} 

	

}
