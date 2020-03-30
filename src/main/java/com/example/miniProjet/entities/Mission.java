package com.example.miniProjet.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mission")
public class Mission {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id_mission;
	private String name;
	private String description;
	@ManyToOne
	@JsonIgnoreProperties(value="missions")
	@JoinColumn(name="DEPT_ID")
	private Departement dept;
	@ManyToMany(mappedBy="missions", cascade= {CascadeType.ALL})
	@JsonIgnoreProperties(value="missions")
	private List<Employe> employees;
	
	public Mission() {
	}
	
	
	public int getId_mission() {
		return id_mission;
	}


	public void setId_mission(int id_mission) {
		this.id_mission = id_mission;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Departement getDept() {
		return dept;
	}
	public void setDept(Departement dept) {
		this.dept = dept;
		
	}
	public List<Employe> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employe> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Mission [id_mission=" + id_mission + ", name=" + name + ", description=" + description + ", dept="
				+ dept + ", employees=" + employees + "]";
	}
	
	
}
