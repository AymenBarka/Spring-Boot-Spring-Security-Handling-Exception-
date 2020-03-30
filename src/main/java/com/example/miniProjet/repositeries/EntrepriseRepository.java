package com.example.miniProjet.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniProjet.entities.Entreprise;
@Repository("EntrepriseRepository")
public interface EntrepriseRepository extends JpaRepository<Entreprise , Integer> {

}
