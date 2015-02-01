package org.sapient.ldap.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

import org.sapient.ldap.domain.User;
import org.sapient.ldap.service.LdapProvisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

/**
 * @author psiva2
 * 
 */
@Service("ldapProvisionService")
public class LdapProvisionServiceImpl implements LdapProvisionService {

	public static final String BASE_DN = "dc=example,dc=com";

	private LdapTemplate ldapTemplate;

	@Autowired
	public LdapProvisionServiceImpl(LdapContextSource contextSource) {
		this.ldapTemplate = new LdapTemplate(contextSource);
	}

	private static class UserAttributesMapper implements AttributesMapper {

		public Object mapFromAttributes(Attributes attrs)
				throws NamingException {
			User user = new User();
			if (attrs.get("uid") != null) {
				user.setUserName((String) attrs.get("uid").get());
			}
			if (attrs.get("cn") != null) {
				user.setFirstName((String) attrs.get("cn").get());
			}
			if (attrs.get("sn") != null) {
				user.setLastName((String) attrs.get("sn").get());
			}
			if (attrs.get("mail") != null) {
				user.setEmail((String) attrs.get("mail").get());
			}
			return user;
		}
	}

	public void setLdapTemplate(final LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public boolean authenticate(String userName, String password) {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "person")).and(
				new EqualsFilter("uid", userName));
		return ldapTemplate.authenticate(DistinguishedName.EMPTY_PATH,
				filter.toString(), password);
	}

	public User getUser(final String userName) {
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "person")).and(
				new EqualsFilter("uid", userName));
		@SuppressWarnings("unchecked")
		List<User> users = ldapTemplate.search(DistinguishedName.EMPTY_PATH,
				filter.encode(), new UserAttributesMapper());
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	public User save(final User user) {
		Name dn = buildDn(user);
		ldapTemplate.bind(dn, null, buildAttributes(user));
		return user;
	}

	public User update(final User user) {
		Name dn = buildDn(user);
		ldapTemplate.rebind(dn, null, buildAttributes(user));
		return user;
	}

	public void delete(User user) {
		Name dn = buildDn(user);
		ldapTemplate.unbind(dn);
	}

	private Name buildDn(final User user) {
		DistinguishedName dn = new DistinguishedName();
		dn.add("ou", "Users");
		dn.add("uid", user.getUserName());
		return dn;
	}

	private Attributes buildAttributes(final User user) {
		Attributes attrs = new BasicAttributes();
		BasicAttribute ocattr = new BasicAttribute("objectclass");
		ocattr.add("person");
		ocattr.add("inetOrgPerson");
		attrs.put(ocattr);
		attrs.put("cn", user.getFirstName());
		attrs.put("sn", user.getLastName());
		attrs.put("userPassword", "{SHA}" + this.encrypt(user.getPassword()));
		attrs.put("mail", user.getEmail());

		return attrs;
	}

	@SuppressWarnings("restriction")
	private String encrypt(final String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage());
		}
		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}

}