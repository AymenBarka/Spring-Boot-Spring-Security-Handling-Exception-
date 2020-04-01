package com.example.miniProjet.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.miniProjet.entities.Employe;

@Repository("EmployeRepository")
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
	@Query("SELECT em FROM Employe em WHERE em.username=:username")
	Employe findByUsername(@Param("username") String username);
}
