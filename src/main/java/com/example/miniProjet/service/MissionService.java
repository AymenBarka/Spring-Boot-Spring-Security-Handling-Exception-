package com.example.miniProjet.service;

import java.util.List;

import com.example.miniProjet.entities.Mission;


public interface MissionService {

	public void addMission(Mission mis);
	public Mission updateMission(Mission mis, int id);
	public String deleteMission(int mis);
	public Mission getMission(int mis);
	public List<Mission> getAllMission();
    public void affectMissionToDept(int idMis, int idDept);


}
