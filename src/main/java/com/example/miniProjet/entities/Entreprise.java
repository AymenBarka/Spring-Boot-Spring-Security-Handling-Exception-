package com.example.miniProjet.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="entreprise")
public class Entreprise {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String raisonSociale;
	@OneToMany(mappedBy="ste")
	@JsonIgnoreProperties("ste")
	private List<Departement> departements;
	
	
	
	public Entreprise() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public List<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	
	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", raisonSociale=" + raisonSociale + ", departements=" + departements + "]";
	}
	
	
}
