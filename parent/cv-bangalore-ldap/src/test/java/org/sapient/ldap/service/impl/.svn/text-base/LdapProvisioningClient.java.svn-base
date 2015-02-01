/**
 * 
 */
package org.sapient.ldap.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sapient.ldap.domain.User;
import org.sapient.ldap.service.LdapProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author psiva2
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext-ldap.xml" })
public class LdapProvisioningClient {

	@Autowired
	@Qualifier("ldapProvisionService")
	private LdapProvisionService ldapProvisionService;

	User user = null;

	@Before
	public void setUp() throws Exception {
		BasicConfigurator.configure();
		user = new User();
		user.setFirstName("Prabu");
		user.setLastName("Sivakumar");
		user.setUserName("psiva2");
		user.setPassword("password");
		user.setEmail("psivakumar2@sapient.com");
		user.setTelephoneNumber("+91 990 002 1257");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		ldapProvisionService.save(user);
		Boolean isAuthenticated = ldapProvisionService.authenticate("psiva2",
				"password");
		assertTrue(isAuthenticated);
		ldapProvisionService.delete(user);
		isAuthenticated = ldapProvisionService.authenticate("psiva2",
				"password");
		assertFalse(isAuthenticated);
	}

}
