package com.example.miniProjet.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniProjet.entities.Departement;
import com.example.miniProjet.entities.Employe;
import com.example.miniProjet.entities.Mission;
import com.example.miniProjet.entities.Role;
import com.example.miniProjet.repositeries.DepartementRepository;
import com.example.miniProjet.repositeries.EmployeRepository;
import com.example.miniProjet.repositeries.MissionRepository;



@Service(value="employeService")
@Transactional

public class EmployeServiceIMPL implements EmployeService, UserDetailsService{
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired 
	MissionRepository missionRepository;
		
	

	@Override
	public void addEmploye(Employe em) {
		em.setPassword(bcryptEncoder.encode(em.getPassword()));
     employeRepository.save(em)	;	
	}

	@Override
	public Employe updateEmploye(Employe em, int id) {
		Employe  emp =employeRepository.findById(em.getId()).orElse(null);
		
		emp.setNom(emp.getNom());
		emp.setPrenom(emp.getPrenom());
		emp.setRole(emp.getRole());
		emp.setIsActif(emp.getIsActif());
		return employeRepository.save(emp);
	}

	@Override
	public String deleteEmploye(int em) {
		Optional<Employe> empl = employeRepository.findById(em);
		if(empl.isPresent()) {
			employeRepository.delete(empl.get()); 
			return "employe is deleted by id "+ em;
		}
		throw new RuntimeException("Not found Employe");
	}

	@Override
	public Employe getEmploye(int em) {
		
		return employeRepository.findById(em).get();
	}

	@Override
	public List<Employe> getAllEmploye()  {
		List<Employe>list = new ArrayList<>();
		
		 employeRepository.findAll().iterator().forEachRemaining(list::add);
		 return list;
	}

	@Override
	public void affectEmpToDept(int idEmp, int idDept) {
		Employe empl = employeRepository.findById(idEmp).get();
		Departement depart= departementRepository.findById(idDept).get();
		List<Employe> liste = depart.getEmployees();
		liste.add(empl);
		depart.setEmployees(liste);
		List<Departement>dept= empl.getDepartement();
		dept.add(depart);
		empl.setDepartement(dept);
		departementRepository.save(depart);
		employeRepository.save(empl);		
	}

	@Override
	public void affectEmpToMiss(int idEmp, int idMiss) {
		Employe empl = employeRepository.findById(idEmp).get();
		Mission mission= missionRepository.findById(idMiss).get();
		List<Employe> liste = mission.getEmployees();
		liste.add(empl);
		mission.setEmployees(liste);
		List<Mission> miss= empl.getMissions();
		miss.add(mission);
		empl.setMissions(miss);
		missionRepository.save(mission);
		employeRepository.save(empl);		
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employe em = employeRepository.findByUsername(username);
		if(em == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(em.getUsername(), em.getPassword(), getAuthority(em));
	}
	private Set<SimpleGrantedAuthority> getAuthority(Employe em) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		Role role = em.getRole();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		return authorities;
	}

	@Override
	public Employe findByUsername(String username) {
		Employe em = employeRepository.findByUsername(username);
		return em;
	}
	

}
