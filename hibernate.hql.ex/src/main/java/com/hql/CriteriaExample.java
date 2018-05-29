package com.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("deprecation")
public class CriteriaExample {

	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	static {
		System.out.println("Loading hibernate configurations................................................");
		configuration = new AnnotationConfiguration();
		configuration.configure(); 
		sessionFactory = configuration.buildSessionFactory();
		System.out.println("Hibernate configurations loaded!!!");
	}
	public static void criteria() {
		Session session= sessionFactory.openSession();
		//Select all
		Criteria criteria=session.createCriteria(Employee.class);
		List<Employee> emp=criteria.list();
		System.out.println("\n---Select *---");
		for(Employee e:emp) {
			System.out.println(e);
		}
		//Select with Restriction
		System.out.println("\n---Select with restriction salary > 45000.00---");
		criteria.add(Restrictions.gt("salary", 45000.00 ));
		emp=criteria.list();
		for(Employee e:emp) {
			System.out.println(e);
		}

		
		// AND condition
		Criteria criteria1=session.createCriteria(Employee.class);
		System.out.println("\n---Select with AND condition---");
		Criterion salary= Restrictions.gt("salary", 20000.00);
		Criterion name= Restrictions.like("emp_Name", "A%");
		
		LogicalExpression lexp= Restrictions.and(salary,name);
		criteria1.add(lexp);
		emp=criteria1.list();
		for(Employee e:emp) {
			System.out.println(e);
		}
		
		//Pagination
		
		Criteria criteria2=session.createCriteria(Employee.class);
		System.out.println("\n---Select with Pagination---");
		Criterion salary1= Restrictions.gt("salary", 20000.00);
		Criterion name1= Restrictions.like("emp_Name", "A%");
		
		LogicalExpression lexp1= Restrictions.and(salary1,name1);
		criteria2.setFirstResult(0);
		criteria2.setMaxResults(2);
		criteria2.add(lexp1);
		emp=criteria2.list();
		for(Employee e:emp) {
			System.out.println(e);
		}
		
		//sorting
		System.out.println("\n---Ordering--");
		criteria1.addOrder(Order.asc("salary"));
		emp=criteria1.list();
		for(Employee e:emp) {
			System.out.println(e);
		}
		
		//Projections 
		Criteria criteria3=session.createCriteria(Employee.class);
		System.out.println("\n---Select with Projections---");
		criteria3.setProjection(Projections.rowCount());
		System.out.println(criteria3.list());
	
	    criteria3.setProjection(Projections.avg("salary"));
	    List avgSalary = criteria3.list();
        System.out.println("Average Salary: " + avgSalary.get(0) );
		
        Criteria criteria4=session.createCriteria(Employee.class);
        criteria3.setProjection(Projections.projectionList()
        		.add(Projections.property("emp_Id"))
        		.add(Projections.property("emp_Name")));
        criteria3.addOrder(Order.asc("emp_Name"));
        List<Object[]> obj=criteria3.list();
		for(Object[] o:obj) {
			System.out.println(o[0]+"\t"+o[1]);
		}
        
	}
	public static void main(String[] args) {
		criteria();

	}

}
