package com.example.miniProjet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniProjet.entities.Departement;
import com.example.miniProjet.entities.Mission;
import com.example.miniProjet.repositeries.DepartementRepository;
import com.example.miniProjet.repositeries.MissionRepository;

@Service
@Transactional

public class MissionServiceIMPL implements MissionService {
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository departementRepository;

	@Override
	public void addMission(Mission mis) {
     missionRepository.save(mis);	
	}

	@Override
	public Mission updateMission(Mission mis, int id) {
		Mission miss = missionRepository.findById(mis.getId_mission()).orElse(null);
		miss.setName(mis.getName());
		miss.setDescription(mis.getDescription());
		return missionRepository.save(miss);
	}

	@Override
	public String deleteMission(int mis) {
		Optional<Mission> misst = missionRepository.findById(mis);
		if(misst.isPresent()) {
			missionRepository.delete(misst.get());
			return "mission is deleted by id" + mis;
		}
		throw  new RuntimeException ("Not found Mission");
	}

	@Override
	public Mission getMission(int mis) {
		return missionRepository.findById(mis).get();
	}

	@Override
	public List<Mission> getAllMission() {
		return missionRepository.findAll();
	}

	@Override
	public void affectMissionToDept(int idMis, int idDept) {
		Mission mission1=missionRepository.findById(idMis).get();
		Departement depart=departementRepository.findById(idDept).get();
		mission1.setDept(depart);
		List<Mission>lists=depart.getMissions();
		lists.add(mission1);
		depart.setMissions(lists);
		missionRepository.save(mission1);
		departementRepository.save(depart);
		
	}

	
	
	

}
