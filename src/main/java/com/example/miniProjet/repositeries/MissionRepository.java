package com.example.miniProjet.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miniProjet.entities.Mission;
@Repository("MissionRepository")
public interface MissionRepository extends JpaRepository<Mission, Integer> {

}
