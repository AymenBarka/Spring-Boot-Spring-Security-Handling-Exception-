package com.example.miniProjet.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniProjet.entities.Employe;
@Repository("EmployeRepository")
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
