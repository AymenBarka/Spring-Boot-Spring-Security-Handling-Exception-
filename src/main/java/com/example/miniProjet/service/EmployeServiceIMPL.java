package com.example.miniProjet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniProjet.entities.Departement;
import com.example.miniProjet.entities.Employe;
import com.example.miniProjet.entities.Mission;
import com.example.miniProjet.repositeries.DepartementRepository;
import com.example.miniProjet.repositeries.EmployeRepository;
import com.example.miniProjet.repositeries.MissionRepository;

@Service
@Transactional

public class EmployeServiceIMPL implements EmployeService{
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired 
	MissionRepository missionRepository;
	

	@Override
	public void addEmploye(Employe em) {
     employeRepository.save(em)	;	
	}

	@Override
	public Employe updateEmploye(Employe em, int id) {
		Employe  emp =employeRepository.findById(em.getId()).orElse(null);
		
		emp.setNom(emp.getNom());
		emp.setPrenom(emp.getPrenom());
		emp.setRole(emp.getRole());
		emp.setIsActif(emp.getIsActif());
		return employeRepository.save(emp);
	}

	@Override
	public String deleteEmploye(int em) {
		Optional<Employe> empl = employeRepository.findById(em);
		if(empl.isPresent()) {
			employeRepository.delete(empl.get()); 
			return "employe is deleted by id "+ em;
		}
		throw new RuntimeException("Not found Employe");
	}

	@Override
	public Employe getEmploye(int em) {
		return employeRepository.findById(em).get();
	}

	@Override
	public List<Employe> getAllEmploye() {
		return employeRepository.findAll();
	}

	@Override
	public void affectEmpToDept(int idEmp, int idDept) {
		Employe empl = employeRepository.findById(idEmp).get();
		Departement depart= departementRepository.findById(idDept).get();
		List<Employe> liste = depart.getEmployees();
		liste.add(empl);
		depart.setEmployees(liste);
		List<Departement>dept= empl.getDepartement();
		dept.add(depart);
		empl.setDepartement(dept);
		departementRepository.save(depart);
		employeRepository.save(empl);		
	}

	@Override
	public void affectEmpToMiss(int idEmp, int idMiss) {
		Employe empl = employeRepository.findById(idEmp).get();
		Mission mission= missionRepository.findById(idMiss).get();
		List<Employe> liste = mission.getEmployees();
		liste.add(empl);
		mission.setEmployees(liste);
		List<Mission> miss= empl.getMissions();
		miss.add(mission);
		empl.setMissions(miss);
		missionRepository.save(mission);
		employeRepository.save(empl);		
		
	}

}
