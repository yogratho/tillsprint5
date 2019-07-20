package com.cg.tms.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Skill {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAB_CUSTOMER_SEQ")
@SequenceGenerator(name="TAB_CUSTOMER_SEQ", sequenceName="TAB_CUSTOMER_SEQ", allocationSize=1)
private int id;


private String employeeId;

private String skillDesc;


public String getSkillDesc() {
	return skillDesc;
}
public void setSkillDesc(String skillDesc) {
	this.skillDesc = skillDesc;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "Skill [id=" + id + ", employeeId=" + employeeId + ", skillDesc=" + skillDesc + "]";
}
public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}


}

