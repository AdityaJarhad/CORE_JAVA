package com.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.core.Brand;
import com.app.core.Material;
import com.app.core.Pens;

public class PenDetails {
	public static List<Pens> populateList() {
		List<Pens> list = new ArrayList<>(Arrays.asList(
		new Pens(Brand.CELLO, "black", "blue", Material.ALLOY_STEEL, 3400, 35, 0),
		new Pens(Brand.PARKER, "brown", "black", Material.METAL, 2750, 25, 0),
		new Pens(Brand.REAYNOLDS, "red", "red", Material.PLASTIC, 5000, 10, 0),
		new Pens(Brand.REAYNOLDS, "green", "blue", Material.PLASTIC, 7000, 07, 0),
		new Pens(Brand.PARKER, "black", "blue", Material.METAL, 3200, 12, 20),
		new Pens(Brand.CELLO, "blue", "red", Material.ALLOY_STEEL, 500, 15, 20)));

//Brand brand, String color, String inkColor, Material material, int stock, Date updateDate, Date listingDate, float price, int discount
		return list;
	}

}
