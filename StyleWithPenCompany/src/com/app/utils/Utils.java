package com.app.utils;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Pens;

public class Utils {

	public static String setDiscount(List<Pens> list) {
		
		int a = LocalDate.now().getMonthValue();
		list.forEach(l -> {
			int b = l.getListingDate().getMonthValue();
			if ((a-b)>3) {
				l.setDiscount(20);
			}
		});
		return "discount added";
	}

	public static String removePens(List<Pens> list) {
		int a = LocalDate.now().getMonthValue();
		list.removeIf(l -> a - l.getListingDate().getMonthValue() > -1);
		return "Removed Succefully";
	}

}
