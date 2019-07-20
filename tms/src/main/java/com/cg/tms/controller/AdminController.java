package com.cg.tms.controller;


import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.tms.entity.Skill;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.service.TrainerService;



@RestController
public class AdminController {
	
	@Autowired
	private TrainerService service;
	public static org.slf4j.Logger log=LoggerFactory.getLogger(AdminController.class);

	@GetMapping(value="/{id}")
	@ResponseBody
	public  List<Skill> getTrainerSkill(@PathVariable("id") String userId)  throws ProgramException {
		log.info("Fetching the skills of trainer having id"+userId);
		String regex="[0-9]{6}IN";
		
		if(!(userId.matches(regex)))
			throw new ProgramException();
		
		log.info("Skills of trainerid "+userId+" is successfully fetched");
		return service.getSkill(userId);
		
	}
	
	
	@PostMapping(path="/addSkill" ,produces = "application/json" , consumes = "application/json")
	public String addSkill(@RequestBody Skill skill) throws ProgramException
	{
		log.info("Addition of"+skill+" is in progress");
		String regex="[0-9]{6}IN";
		if(skill.getEmployeeId().matches(regex))
			throw new ProgramException();

		return service.addSkill(skill.getEmployeeId(), skill.getSkillDesc());
	}
	@GetMapping(value="/delete/{id}")
	@ResponseBody
	public String delSKill(@PathVariable("id") Integer userId)  {
		
		
		return service.delSkill(userId);
	}
	
	@GetMapping(value = "/mostVersatileTrainer")
	@ResponseBody
	public String mostVersatile()
	{
		
		return service.versatileTrainer();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping(value="/")
//	@ResponseBody
//	public String showHomePage()  {
//		
//		throw new RuntimeException("Dummy Exception");
//		
//	}
//	

}