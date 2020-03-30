package com.example.miniProjet.service;

import java.util.List;

import com.example.miniProjet.entities.Departement;


public interface DepartementService {
	public void addDepartement(Departement dep);
	public Departement updateDepartement(Departement dep, int id);
	public String deleteDepartement(int dep);
	public Departement getDepartement(int dep);
	public List<Departement> getAllDepartement();
    public void affectDeptToEnt(int idDept, int idEnt);
}
