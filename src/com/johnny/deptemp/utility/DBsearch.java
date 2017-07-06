package com.johnny.deptemp.utility;

import java.util.Iterator;
import java.util.List;

import com.johnny.deptemp.entity.Department;
@Deprecated
public class DBsearch {
	
	public static Department getDeptById(List<Department> allDept, Integer deptId){
		if (allDept == null){
			return null;
		}
		Department dept;
		Iterator<Department> it = allDept.iterator();
		while (it.hasNext()){
			dept = (Department) it.next();
			if (dept.getDeptId() == deptId){
				return dept;
			}
		}
		return null;
	}

}
