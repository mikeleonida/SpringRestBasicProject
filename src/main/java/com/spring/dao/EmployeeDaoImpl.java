package com.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	List<Employee> allEmployees = new ArrayList<Employee>();
	
	@Override
	public boolean addEmployee(Employee e) {
		allEmployees.add(e);
		return true;
	}

	@Override
	public boolean updateEmployee(int employeeNo, Employee e) {
		for (Employee employee : allEmployees) {
			if (employee.getEmployeeId() == employeeNo) {
				allEmployees.remove(employee);
				allEmployees.add(e);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeNo) {
		for (Employee employee : allEmployees) {
			if (employee.getEmployeeId() == employeeNo) {
				allEmployees.remove(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee getEmployeeByNo(int employeeNo) {
		for (Employee employee : allEmployees) {
			if (employee.getEmployeeId() == employeeNo) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

}
