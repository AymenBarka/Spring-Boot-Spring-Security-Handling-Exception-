package com.example.miniProjet.service;

import java.util.List;

import com.example.miniProjet.entities.Contrat;


public interface ContratService {
	public void addContrat(Contrat crt);
	public Contrat updateContrat(Contrat crt , int id);
	public String deleteContrat(int crt);
	public Contrat getContrat(int crt);
	public List<Contrat> getAllContrat();

}
