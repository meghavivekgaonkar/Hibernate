package com.session.caching;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class FirstLevelCache {
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	static {
		System.out.println("Loading hibernate configurations................................................");
		configuration = new AnnotationConfiguration();
		System.out.println("1");
		configuration.configure();
		System.out.println("2");
		sessionFactory = configuration.buildSessionFactory();
		System.out.println("Hibernate configurations loaded!!!");
	}

	public static void main(String[] args) {
		Session session = null;
		Session session1 = null;
		try {
			session = sessionFactory.openSession();
			CustomerCache cust = (CustomerCache) session.get(CustomerCache.class, 101);
			System.out.println("Call 1: \nCustomer Object:" + cust);
			CustomerCache cust1 = (CustomerCache) session.get(CustomerCache.class, 101);
			System.out.println("Call 2: \nCustomer Object:" + cust1);
			session.close();

			session1 = sessionFactory.openSession();
			CustomerCache cust2 = (CustomerCache) session1.get(CustomerCache.class, 101);
			System.out.println("Call 3: \nCustomer Object:" + cust2);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
