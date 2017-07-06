package com.johnny.deptemp.utility;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;

public class LoadDB {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DeptEmpHouJPA");
	@SuppressWarnings("unchecked")
	public static List<Department> loadDept(){
		List<Department> allDept = new ArrayList<Department>();
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		em.flush();
		allDept = em.createNamedQuery("getAllDept").getResultList();
		em.getTransaction().commit();
		em.close();		 
		return allDept;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Employee> loadEmp(){
		List<Employee> allEmp = new ArrayList<Employee>();
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		em.flush();
		allEmp = em.createNamedQuery("getAllEmp").getResultList();
		em.getTransaction().commit();
		em.close();
		return allEmp;
	}

}
