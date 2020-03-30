package com.example.miniProjet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniProjet.entities.Contrat;
import com.example.miniProjet.repositeries.ContratRepository;

@Service
@Transactional
public class ContratServiceIMPL implements ContratService {
	
    @Autowired
	ContratRepository contratRepository;

	@Override
	public void addContrat(Contrat crt) {
    contratRepository.save(crt)	;	
	}

	@Override
	public Contrat updateContrat(Contrat crt, int id) {
		Contrat existingCrt = contratRepository.findById(crt.getReference()).orElse(null);
		existingCrt.setDateDebut(crt.getDateDebut());
		existingCrt.setTypeContrat(crt.getTypeContrat());
		existingCrt.setSalaire(crt.getSalaire());
		return contratRepository.save(existingCrt);
		
	}

	@Override
	public String deleteContrat(int crt) {
	Optional<Contrat> cont = contratRepository.findById(crt);
	if(cont.isPresent()) {
		contratRepository.delete(cont.get());
		return "contrat is deleted by id " +crt;
		
	}
	throw new RuntimeException ("Not Found Contrat");
	}

	@Override
	public Contrat getContrat(int crt) {
		
		return contratRepository.findById(crt).get();
	}

	@Override
	public List<Contrat> getAllContrat() {
		return contratRepository.findAll();
	}
}
