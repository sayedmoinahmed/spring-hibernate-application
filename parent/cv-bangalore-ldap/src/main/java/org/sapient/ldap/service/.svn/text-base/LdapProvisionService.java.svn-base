package org.sapient.ldap.service;

import org.sapient.ldap.domain.User;

public interface LdapProvisionService {

	User getUser(final String userName);

	User save(final User user);

	boolean authenticate(final String userName, final String password);

	void delete(final User user);
}
