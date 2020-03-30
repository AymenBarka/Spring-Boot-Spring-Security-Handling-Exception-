package com.example.miniProjet.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employe")
public class Employe {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private Boolean isActif;
	private String Role;
	@ManyToMany(mappedBy="employees", cascade= {CascadeType.ALL})
	@JsonIgnoreProperties(value="employees")
	private List <Departement>departement;
	@ManyToMany(cascade= CascadeType.ALL)
	@JsonIgnoreProperties("employees")
	@JoinTable (
			name="Emp_Miss",
			joinColumns= {
					@JoinColumn(name="Emp_ID")
			},
			inverseJoinColumns= {
					@JoinColumn(name="Miss_ID")
			}
			
			)
	
	private List<Mission>missions;
	@OneToOne(mappedBy="employees")
	private Contrat contrat;
	
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public List<Departement> getDepartement() {
		return departement;
	}
	public void setDepartement(List<Departement> departement) {
		this.departement = departement;
	}
	public Employe() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", isActif=" + isActif + ", Role=" + Role
				+ ", departement=" + departement + ", missions=" + missions + "]";
	}
	
	
	
}
