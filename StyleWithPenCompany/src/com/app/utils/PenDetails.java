package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.time.LocalDate.parse;

import java.time.LocalDate;

import com.app.core.Brand;
import com.app.core.Material;
import com.app.core.Pens;

public class PenDetails {
	public static List<Pens> populateList() {
		List<Pens> list = new ArrayList<>(Arrays.asList(
		new Pens(Brand.CELLO, "black", "blue", Material.ALLOY_STEEL, 3400, LocalDate.now(), parse("2024-04-12"), 35, 0),
		new Pens(Brand.PARKER, "brown", "black", Material.METAL, 2750, LocalDate.now(), parse("2024-03-18"), 25, 0),
		new Pens(Brand.REAYNOLDS, "red", "red", Material.PLASTIC, 5000, LocalDate.now(), parse("2024-05-22"), 10, 0),
		new Pens(Brand.REAYNOLDS, "green", "blue", Material.PLASTIC, 7000, LocalDate.now(), parse("2024-01-02"), 07, 0),
		new Pens(Brand.PARKER, "black", "blue", Material.METAL, 3200, LocalDate.now(), parse("2023-12-02"), 12, 20),
		new Pens(Brand.CELLO, "blue", "red", Material.ALLOY_STEEL, 500, LocalDate.now(), parse("2024-01-02"), 15, 20)));

//Brand brand, String color, String inkColor, Material material, int stock, Date updateDate, Date listingDate, float price, int discount
		return list;
	}

}
