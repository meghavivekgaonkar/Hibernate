package com.session.annotations;

public interface ICustomer {

	public abstract void saveCustomer(final CustomerNew customer);

	public abstract void getCustomer(final int id);

	public abstract void updateCustomer(final CustomerNew customer);

	public abstract void removeCustomer(final CustomerNew customer);
}
