package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Cricketers;

public class CricketerDetails {

	public static List<Cricketers> populateList() {
		List<Cricketers> list = new ArrayList<>(
				Arrays.asList(new Cricketers("King Kohli", 35, "vk@gmail.com", "645345", 10),
						new Cricketers("Rahit Sharma", 37, "rs@gmail.com", "544564", 9),
						new Cricketers("Ms. Dhoni", 43, "7@gmail.com", "845345", 9),
						new Cricketers("Bumrah", 33, "boom@gmail.com", "895344", 8),
						new Cricketers("Chahal", 30, "ch@gmail.com", "613879", 7)));
		return list;
	}
	
	public static Map<String, Cricketers> populateMap(List<Cricketers> list){
		Map<String, Cricketers> map = new HashMap<>();
		list.forEach(l -> map.put(l.getEmail(), l));
		
		
		return map;
	}
}