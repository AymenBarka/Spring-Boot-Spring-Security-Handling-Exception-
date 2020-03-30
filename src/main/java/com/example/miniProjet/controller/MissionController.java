package com.example.miniProjet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniProjet.entities.Mission;
import com.example.miniProjet.service.DepartementService;
import com.example.miniProjet.service.MissionService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(value="/Missions")
public class MissionController {
@Autowired
MissionService missionservice;
@Autowired
DepartementService departementService;

@PostMapping("/addMission")
public void addMission(@RequestBody Mission mis) {
	missionservice.addMission(mis);
}

@PutMapping("/updateMission/{id}")
public Mission updateMission(@RequestBody Mission mis, @PathVariable (value="id") int id) {
	return missionservice.updateMission(mis, id);
}

@DeleteMapping("/deleteMission/{id}")
public String deleteMission(@PathVariable (value = "id") int mis) {
	return missionservice.deleteMission(mis);
}

@GetMapping("/getMission/{id}")
public Mission getMission(@PathVariable (value="id") int mis) {
	return missionservice.getMission(mis);
}

public List<Mission> getAllMission() {
	return missionservice.getAllMission();
}
@GetMapping("/affectMissonDepartement/{idMis}/{idDept}")
public void affectMissionToDept(@PathVariable (value="idMis") int idMis,@PathVariable (value="idDept")  int idDept) {
	missionservice.affectMissionToDept(idMis, idDept);
}

}
