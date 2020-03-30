package com.example.miniProjet.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contrat")
public class Contrat {
    @Id
    
	private int reference;
	private String dateDebut;
	private String typeContrat;
	private int salaire;
	@OneToOne
	private Employe employees;
	public Contrat() {

	}
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	@Override
	public String toString() {
		return "Contrat [reference=" + reference + ", dateDebut=" + dateDebut + ", typeContrat=" + typeContrat
				+ ", salaire=" + salaire + "]";
	}
	
	
}
