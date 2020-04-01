package com.example.miniProjet.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="employe")
public class Employe   {
	

	

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private Boolean isActif;
	@OneToOne
	private Role role;
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
	@NotNull
	private String username;
	private String password;
	public Employe() {
	}
	
	
	public Employe(int id, String nom, String prenom, Boolean isActif, Role role, List<Departement> departement,
			List<Mission> missions, Contrat contrat, @NotNull String username, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.isActif = isActif;
		this.role = role;
		this.departement = departement;
		this.missions = missions;
		this.contrat = contrat;
		this.username = username;
		this.password = password;
	}
	


	public Employe(@NotNull String username, String password) {
		this.username = username;
		this.password = password;
	}


	public Employe(String nom, String prenom, Boolean isActif, Role role, List<Departement> departement,
			List<Mission> missions, Contrat contrat, @NotNull String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.isActif = isActif;
		this.role = role;
		this.departement = departement;
		this.missions = missions;
		this.contrat = contrat;
		this.username = username;
		this.password =password;
	}


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
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", isActif=" + isActif + ", role=" + role
				+ ", departement=" + departement + ", missions=" + missions + ", contrat=" + contrat + "]";
	}
	
	
	
}
