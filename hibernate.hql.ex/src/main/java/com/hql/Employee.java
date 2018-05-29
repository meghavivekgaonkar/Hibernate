package com.hql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@SuppressWarnings("serial")
@Entity
@Table(name="EmployeeHQL")

public class Employee implements Serializable{
	@Id
	@Column(name="EmpId", length=4)
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private int emp_Id;
	@Column(name="EmpName", length=20, nullable=false)
	private String emp_Name;
	@Column(name="Salary", nullable=false)
	private double salary;
	@Column(name="DeptNo", length=4, nullable=false)
	private int dept_No;
	
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDept_No() {
		return dept_No;
	}
	public void setDept_No(int dept_No) {
		this.dept_No = dept_No;
	}
	@Override
	public String toString() {
		return "Employee [emp_Id=" + emp_Id + ", emp_Name=" + emp_Name + ", salary=" + salary + ", dept_No=" + dept_No
				+ "]";
	}
	

	

}
