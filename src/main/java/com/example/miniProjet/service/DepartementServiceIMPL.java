package com.example.miniProjet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniProjet.entities.Departement;
import com.example.miniProjet.entities.Entreprise;
import com.example.miniProjet.repositeries.DepartementRepository;
import com.example.miniProjet.repositeries.EntrepriseRepository;

@Service
@Transactional
public class DepartementServiceIMPL implements DepartementService {
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	

	@Override
	public void addDepartement(Departement dep) {
        departementRepository.save(dep)	;	
	}

	@Override
	public Departement updateDepartement(Departement dep, int id) {
		Departement depart = departementRepository.findById(dep.getId_departement()).orElse(null);
		depart.setNomDepartement(dep.getNomDepartement());	
		return departementRepository.save(depart);
		
	}

	@Override
	public String deleteDepartement(int dep) {
		Optional<Departement> dept = departementRepository.findById(dep);
		if(dept.isPresent()) {
			departementRepository.delete(dept.get()); 
			return "departement is deleted by id "+ dep;
		}
		throw new RuntimeException("Not found Departement");
	}

	@Override
	public Departement getDepartement(int dep) {
		return departementRepository.findById(dep).get();

	}

	@Override
	public List<Departement> getAllDepartement() {
		return departementRepository.findAll();

	}

	@Override
	public void affectDeptToEnt(int idDept, int idEnt) {
		Departement depart= departementRepository.findById(idDept).get();
		Entreprise entre= entrepriseRepository.findById(idEnt).get();
		depart.setSte(entre);
		List<Departement>lists=entre.getDepartements();
		lists.add(depart);
		entre.setDepartements(lists);
		departementRepository.save(depart);
		entrepriseRepository.save(entre);
		
	}
	

}
