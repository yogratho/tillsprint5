package com.cg.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.dao.TrainerDao;
import com.cg.tms.entity.Skill;

@Service
public class TrainerServiceImpl implements TrainerService

	{
	@Autowired
	private TrainerDao dao;
	@Override
	public String addSkill(String trainerID, String skill) {
		

		return dao.addSkill(trainerID, skill);
	}

	@Override
	public String delSkill(Integer trainerID) {
		
		return dao.delSkill(trainerID);
	}

	@Override
	public List<Skill> getSkill(String trainerID) {
		System.out.println(trainerID);
		return dao.getSkill(trainerID);
	}

	@Override
	public String versatileTrainer() {
		return dao.findSkilledTrainer();
	}

}
