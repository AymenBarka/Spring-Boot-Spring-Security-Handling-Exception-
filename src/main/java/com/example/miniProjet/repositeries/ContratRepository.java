package com.example.miniProjet.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniProjet.entities.Contrat;
@Repository("ContratRepository")
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

}
