package com.app.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.app.core.Cricketers;
import com.app.exception.CustumException;

public class Validations {
	public static void searchByName(String name, Map<String, Cricketers> map) {
		for (Cricketers c : map.values()) {
			if(c.getName().equals(name)) {
				System.out.println(c);
			}
		}
	}
	
	public static void sortByRating(Map<String, Cricketers> map) {
		List<Cricketers> list = new ArrayList<>(map.values());
//		Collections.sort(list.ra);
		
		Comparator<Cricketers> comp = (c1, c2) -> c1.getRating();
		map.forEach((k, v) -> {

		});
	}
	
	public static Cricketers validateEmail(String em, Map<String, Cricketers> map) throws CustumException {
		for (Cricketers c : map.values()) {
			if(c.getEmail().equals(em)) {
				return c;
			}
		}
		throw new CustumException("Email not found!!!");
	}
	
	public static String changeRating(String em, int rating, Map<String, Cricketers> map) throws CustumException {
		validateEmail(em, map);
		for (Cricketers c : map.values()) {
			if(c.getEmail().equals(em)) {
				c.setRating(rating);
				map.put(c.getEmail(), c);
				return "Password update successfully";
			}
		}
		return "Updation failed";
	}
}
