package com.example.miniProjet.service;

import java.util.List;

import com.example.miniProjet.entities.Employe;


public interface EmployeService {

	public void addEmploye(Employe em);
	public Employe updateEmploye(Employe em, int id);
	public String deleteEmploye(int em);
	public Employe getEmploye(int em);
	public List<Employe> getAllEmploye();
	public void affectEmpToDept(int idEmp, int idDept);
	public void affectEmpToMiss(int idEmp, int idMiss);



}
