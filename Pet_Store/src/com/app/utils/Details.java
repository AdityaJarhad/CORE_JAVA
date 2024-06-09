package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Category;
import com.app.core.Order;
import com.app.core.Pet;
import com.app.core.Status;

public class Details {
	// orderId=1, petId=101, quantity=5, status=PLACED
	// petId = 101, name=” Bull Dog”, category= DOG, unitPrice= 1000, stocks=50

	public static Map<Integer, Pet> populatePet() {
		List<Pet> petList = new ArrayList<>(Arrays.asList(new Pet("Bull Dog", Category.DOG, 1000, Status.PLACED),
				new Pet("Gold Fish", Category.FISH, 300, Status.IN_PROCESS),
				new Pet("Kitty", Category.CAT, 700, Status.COMPLETED)));

		Map<Integer, Pet> petMap = new HashMap<>();
		petList.forEach(l -> petMap.put(l.getPetId(), l));
		return petMap;
	}

	public static Map<Integer, Order> populateOrder() {
		List<Order> orderList = new ArrayList<>(Arrays.asList(new Order(101, 5, Status.PLACED),
				new Order(102, 7, Status.COMPLETED), new Order(103, 4, Status.IN_PROCESS)));
		
		Map<Integer, Order> orderMap = new HashMap<>();
		orderList.forEach(l -> orderMap.put(l.getOrderId(), l));
		return orderMap;
	}
}
