package com.app.utils;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Order;
import com.app.core.Pet;
import com.app.core.Status;

public class Utils {
	
	public static void writeFile(String name) {
		try (ObjectOutputStream objStream = new ObjectOutputStream(new FileOutputStream(name))){
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void upadatePet(int pid, double price, Status status, Map<Integer, Pet> map) throws Exception {
		Pet pet = Validations.validatePid(pid, map);
		pet.setPrice(price);
		pet.setStatus(status);
		map.put(pid, pet);
		System.out.println("Update successfully");
	}
	
	public static void updateOrderStatus(int id, Status status, Map<Integer, Order> map) {
		map.forEach((k, v) -> {
			if(v.getOrderId() == id) {
				v.setStatus(status);
				System.out.println("Status updated");
			}
		});
	}
	
	public static void orderStatus(int id, Map<Integer, Order> map) {
		 map.values()
		.stream()
		.forEach(l -> {
			if(l.getOrderId() == id) {
				System.out.println(l.getStatus());
			}
		});
		
	}
	
}