package com.johnny.deptemp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnny.deptemp.businessLogic.AddDeptService;
import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.utility.LoadDB;

@WebServlet("/addDept")
public class AddDeptServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dName = request.getParameter("deptName");
		String dEmail = request.getParameter("deptEmail");
		AddDeptService.addDept(dName, dEmail);
		
		List<Employee> allEmp = (ArrayList<Employee>) LoadDB.loadEmp();
		List<Department> allDept = (ArrayList<Department>) LoadDB.loadDept();
		request.getServletContext().setAttribute("allEmp", allEmp);
		request.getServletContext().setAttribute("allDept", allDept);
		response.sendRedirect("/DeptEmpHouJPA/addDepartment.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
