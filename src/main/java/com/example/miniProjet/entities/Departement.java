package com.example.miniProjet.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="departement")
public class Departement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_departement;
	
	private String nomDepartement;
	@ManyToOne
	@JoinColumn(name="ENT_ID")

	@JsonIgnoreProperties(value="departements")
	private Entreprise ste;
	@OneToMany(mappedBy="dept")
	@JsonIgnoreProperties("dept")
	private List<Mission>missions;
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnoreProperties("departement")
	@JoinTable (
			name="Dept_Emp",
			joinColumns= {
					@JoinColumn(name="Dept_ID")
			},
			inverseJoinColumns= {
					@JoinColumn(name="Empt_ID")
			}
			
			)
	private List<Employe>employees;
	

	public Departement() {
	}

	public int getId_departement() {
		return id_departement;
	}








	public void setId_departement(int id_departement) {
		this.id_departement = id_departement;
	}








	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public Entreprise getSte() {
		return ste;
	}

	public void setSte(Entreprise ste) {
		this.ste = ste;
	}
	

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	

	

	public List<Employe> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Departement [id_departement=" + id_departement + ", nomDepartement=" + nomDepartement + ", ste=" + ste
				+ ", missions=" + missions + ", employees=" + employees + "]";
	}
	
	
	

}
