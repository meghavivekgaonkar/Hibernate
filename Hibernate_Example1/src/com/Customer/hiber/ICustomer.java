package com.Customer.hiber;

public interface ICustomer {

	public abstract void saveCustomer(final Customer customer);

	public abstract void getCustomer(final int id);

	public abstract void updateCustomer(final Customer customer);

	public abstract void removeCustomer(final Customer customer);
}
