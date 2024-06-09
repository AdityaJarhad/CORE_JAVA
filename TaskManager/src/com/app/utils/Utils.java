package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Task;

public class Utils {
	public static List<Task> populateList() {
		List<Task> list = new ArrayList<>(
				Arrays.asList(new Task("task1", "desc1", LocalDate.parse("2024-01-01")),
						new Task("task2", "desc2", LocalDate.parse("2024-10-05")),
						new Task("task3", "desc3", LocalDate.parse("2024-01-06")),
						new Task("task4", "desc4", LocalDate.parse("2024-06-08")),
						new Task("task5", "desc5", LocalDate.parse("2024-04-11"))));
		return list;
	}
	
	public static Map<Integer, Task> populateMap(List<Task> list){
		Map<Integer, Task> map = new HashMap<>();
		list.forEach(l -> map.put(l.getTaskId(), l));
		
		return map;
	}
}
