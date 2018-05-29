package com.hql;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


@SuppressWarnings("deprecation")
public class HQLDriver {

	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	static {
		System.out.println("Loading hibernate configurations................................................");
		configuration = new AnnotationConfiguration();
		configuration.configure(); 
		sessionFactory = configuration.buildSessionFactory();
		System.out.println("Hibernate configurations loaded!!!");
	}
	public static void save() {
		Session session = null;
		try {
			Employee emp= new Employee();
			emp.setDept_No(24);
			emp.setEmp_Name("Garry");
			emp.setSalary(98765.98);
			
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = session.save(emp);
			transaction.commit();
			System.out.println("Persisted Customer Object ID:" + id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}
	public static void hqlQuery() {
		Session session=null;
		session=sessionFactory.openSession();
		//Select * from table
		Query query= session.createQuery("From Employee");
		List<Employee> list=query.list();
		for(Employee e:list) {
			System.out.println(e);
		}
		//select few rows from table
		query=session.createQuery("SELECT e.salary, e.emp_Name from Employee e");
		List<Object[]> result=query.list();
		for(Object[] obj:result) {
			System.out.println(obj[0]+" \t"+obj[1]);
		}
		//select with where clause
		query=session.createQuery("SELECT e.emp_Id, e.emp_Name, e.dept_No from Employee e where e.salary> 23456");
		List<Object[]> results=query.list();
		for(Object[] obj:results) {
			System.out.println(obj[0]+" \t"+obj[1]);
		}
	}
	public static void main(String[] args) {
		save();
		hqlQuery();

	}

}
