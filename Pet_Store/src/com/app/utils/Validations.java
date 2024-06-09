package com.app.utils;

import java.util.Map;
import java.util.Optional;

import javax.security.sasl.AuthenticationException;

import com.app.core.Pet;

public class Validations {
	public static boolean adminAuth(String id, String pass) throws AuthenticationException {
		if (id.equals("admin") && pass.equals("admin")) {
			return true;
		}
		return false;
	}

	public static boolean custAuth(String id, String pass) throws AuthenticationException {
		if (id.equals("c1") && pass.equals("c1")) {
			return true;
		}
		return false;
	}

	public static boolean logIn(String id, String pass) throws Exception {
		boolean admin;
		if (adminAuth(id, pass)) {
			return admin = true;
		} else if (custAuth(id, pass)) {
			return admin = false;
		} else {
			throw new AuthenticationException("Invalid details !");
		}
	}

	public static Pet validatePid(int id, Map<Integer, Pet> map) throws Exception {

		Optional<Pet> findFirst = map.values().stream().filter(p -> p.getPetId() == id).findFirst();

		return findFirst.orElse(null);
	}

}
