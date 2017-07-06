package com.johnny.deptemp.businessLogic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.johnny.deptemp.entity.Department;

public class AddDeptService {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DeptEmpHouJPA");	
	
	public static void addDept(String deptName, String deptEmail){
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		Department newDept = new Department();
		newDept.setDeptName(deptName);
		newDept.setDeptEmail(deptEmail);
		em.persist(newDept);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

}
