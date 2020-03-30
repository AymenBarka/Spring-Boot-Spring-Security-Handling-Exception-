package com.example.miniProjet.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniProjet.entities.Departement;
@Repository("DepartementRepository")
public interface DepartementRepository extends JpaRepository<Departement , Integer> {

}
