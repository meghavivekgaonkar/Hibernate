package com.Customer.hiber;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class CustomerImpl implements ICustomer {
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	static {
		System.out.println("Loading hibernate configurations................................................");
		configuration = new Configuration();
		System.out.println("1");
		configuration.configure();
		System.out.println("2");
		sessionFactory = configuration.buildSessionFactory();
		System.out.println("Hibernate configurations loaded!!!");
	}

	@Override
	public void saveCustomer(final Customer customer) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = session.save(customer);
			// session.persist(customer);
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

	@Override
	public void getCustomer(final int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Customer customer = (Customer) session.load(Customer.class, id);
			System.out.println("Customer Details:");
			System.out.println(customer);
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

	@Override
	public void updateCustomer(final Customer customer) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(customer);
			transaction.commit();
			System.out.println("Persisted Customer Updated!!!");

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

	@Override
	public void removeCustomer(final Customer customer) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(customer);
			transaction.commit();
			System.out.println("Persisted Customer Deleted!!!");

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

}
