package com.johnny.deptemp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "getAllEmp", query = "from Employee e")
})

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -6029259263564504943L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private Integer age;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department empDept;
	
	public Employee(){
		
	}
	public Employee(Integer empId, String firstName, String lastName, Integer age, Department empDept){
		super();
		if (empId != null) this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.empDept = empDept;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public Integer getAge(){
		return age;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	
	public int getId(){
		return empId;
	}
	public void setId(Integer empId){
		this.empId = empId;
	}
	
	public Department getDept(){
		return empDept;
	}
	public void setDept(Department empDept){
		this.empDept = empDept;
	}

}
