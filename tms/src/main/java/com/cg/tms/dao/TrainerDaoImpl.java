package com.cg.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.tms.entity.Skill;

@Repository
@Transactional

public class TrainerDaoImpl implements TrainerDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public String addSkill(String trainerID, String skill) {

		
		Skill skillobj=new Skill();
		skillobj.setEmployeeId(trainerID);
		skillobj.setSkillDesc(skill);
		
		
		entityManager.persist(skillobj);
		
		
		

		
		return "Skill is Successfully added";
	}

	@Override
	public String delSkill(Integer trainerID) {

		Skill skillObj =entityManager.find(Skill.class,trainerID);
		if(skillObj!=null)
		{
		
		entityManager.remove(skillObj);
		
		return "Skill is Successfully deleted";
		}
		else
			return "No Trainer Found for given entry";
		}

	@Override
	public List<Skill> getSkill(String trainerID) {
		

		
		Query query=entityManager.createQuery("select sk from Skill sk where sk.employeeId=:employeeId");
	      query.setParameter("employeeId", trainerID);
			
	      List<Skill> list=query.getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	public String findSkilledTrainer() {
		
		Query query=entityManager.createQuery("select distinct employeeId from Skill");
		List<String> employeesList=query.getResultList();
		System.out.println(employeesList);
		long skillCount=0;
		String id="";
		for(String eid:employeesList)
		{	
			System.out.println(eid);
			Query query2=entityManager.createQuery("select count(skillDesc) from Skill  where employeeId=:idd");
			query2.setParameter("idd", eid);
			 List<Long> Count=query2.getResultList();
			 System.out.println(Count);
			 System.out.println("Number of skills for trainer id "+eid+" Are"+Count);
			 if(Count.get(0)>=skillCount)
			 {
				 skillCount=Count.get(0);
				 id=eid;
			 }
		}
//		Query query3=entityManager.createQuery("select employeename from employeedb where employeeid=:iddd");
//		query3.setParameter("iddd", id);
//		List<String> name=query3.getResultList();
//		return name.get(0);
		return id;
	}

}
