package com.example.miniProjet.service;

import java.util.List;

import com.example.miniProjet.entities.Entreprise;


public interface EntrepriseService {

	public void addEntreprise(Entreprise ent);
	public Entreprise updateEntreprise(Entreprise ent, int id);
	public String deleteEntreprise(int ent);
	public Entreprise getEntreprise(int ent);
	public List<Entreprise> getAllEntreprise();


}
