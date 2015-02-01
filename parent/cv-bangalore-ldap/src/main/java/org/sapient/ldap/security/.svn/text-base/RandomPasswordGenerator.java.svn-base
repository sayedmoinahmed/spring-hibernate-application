/**
 * 
 */
package org.sapient.ldap.security;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author psiva2
 * 
 */
public class RandomPasswordGenerator {

	private static final Random RANDOM = new SecureRandom();
	private static final int PASSWORD_LENGTH = 8;
	private static final String PASSWORD_COMBINATION = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

	public static String generatePassword() {
		String password = "";
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = (int) (RANDOM.nextDouble() * PASSWORD_COMBINATION
					.length());
			password += PASSWORD_COMBINATION.substring(index, index + 1);
		}
		return password;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			System.out.println("Random Password Generated is: "
					+ generatePassword());
	}
}
