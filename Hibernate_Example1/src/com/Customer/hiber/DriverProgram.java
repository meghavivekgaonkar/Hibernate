package com.Customer.hiber;

import java.util.Scanner;

public class DriverProgram {

	public static void main(String[] args) {
		System.out.println("I am from Main Method");
		ICustomer iCustomer = new CustomerImpl();
		Customer customer = new Customer();
		Scanner s = new Scanner(System.in);
		// System.out.println("Enter ID:");
		// int id = s.nextInt();
		System.out.println("Enter Name:");
		String name = s.next();
		System.out.println("Enter Email:");
		String email = s.next();
		System.out.println("Enter City:");
		String city = s.next();

		// customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);
		customer.setCity(city);
		System.out.println("Save:");
		iCustomer.saveCustomer(customer);
		// System.out.println("Get:");
		// iCustomer.getCustomer(id);
		//
		// System.out.println("Update:");
		// Customer customer1 = new Customer();
		//
		// System.out.println("Enter ID:");
		// id = s.nextInt();
		// System.out.println("Enter Name:");
		// name = s.next();
		// System.out.println("Enter Email:");
		// email = s.next();
		// System.out.println("Enter City:");
		// city = s.next();
		// customer1.setId(id);
		// customer1.setName(name);
		// customer1.setEmail(email);
		// customer1.setCity(city);
		// iCustomer.updateCustomer(customer1);
		//
		// System.out.println("Delete:");
		// Customer customer2 = new Customer();
		//
		// System.out.println("Enter ID:");
		// id = s.nextInt();
		// System.out.println("Enter Name:");
		// name = s.next();
		// System.out.println("Enter Email:");
		// email = s.next();
		// System.out.println("Enter City:");
		// city = s.next();
		// customer2.setId(id);
		// customer2.setName(name);
		// customer2.setEmail(email);
		// customer2.setCity(city);
		// iCustomer.removeCustomer(customer2);

		s.close();
		System.out.println("End of Main Method");
	}

}
