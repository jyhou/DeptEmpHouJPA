package com.johnny.deptemp.businessLogic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;

public class AddEmpService {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("DeptEmpHouJPA");
	
	public static void addEmp(String firstName, String lastName, Integer age, Integer empDeptId){
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		Employee emp = new Employee();
		Department empDept = em.find(Department.class, empDeptId);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setAge(age);		
		emp.setDept(empDept);
		em.persist(emp);
		em.getTransaction().commit();
		em.close();
	}

}
