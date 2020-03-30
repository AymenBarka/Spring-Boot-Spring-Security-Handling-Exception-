package com.example.miniProjet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniProjet.entities.Entreprise;
import com.example.miniProjet.repositeries.EntrepriseRepository;

@Service
@Transactional
public class EntrepriseServiceIMPL implements EntrepriseService {
@Autowired
EntrepriseRepository entrepriseRepository;

@Override
public void addEntreprise(Entreprise ent) {
entrepriseRepository.save(ent)	;
}

@Override
public Entreprise updateEntreprise(Entreprise ent, int id) {
	Entreprise entre = entrepriseRepository.findById(ent.getId()).orElse(null);
	entre.setRaisonSociale(ent.getRaisonSociale());
	return entrepriseRepository.save(entre);
}

@Override
public String deleteEntreprise(int ent) {
	Optional<Entreprise> entrep = entrepriseRepository.findById(ent);
	if(entrep.isPresent()) {
		entrepriseRepository.delete(entrep.get());
		return "entreprise is deleted by id"+ ent;
	}
	throw new RuntimeException ("Entreprise Not found");
}

@Override
public Entreprise getEntreprise(int ent) {
	return entrepriseRepository.findById(ent).get();
}

@Override
public List<Entreprise> getAllEntreprise() {
	return entrepriseRepository.findAll();
}


}


	



