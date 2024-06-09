package com.app.core;

import java.time.LocalDate;

public class Pens {

	private static int id;
	private Brand brand;
	private String color;
	private String inkColor;
	private Material material;
	private int stock;
	private LocalDate updateDate;
	private LocalDate listingDate;
	private float price;
	private int discount;
	
	public Pens() {
		super();
	}

	
	public Pens(Brand brand, String color, String inkColor, Material material, int stock, float price, int discount) {
		super();
		++id;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.updateDate = LocalDate.now();
		this.listingDate = LocalDate.now();
		this.price = price;
		this.discount=discount;
	}
	public Pens(Brand brand, String color, String inkColor, Material material, int stock, float price) {
		super();
		++id;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.updateDate = LocalDate.now();
		this.listingDate = LocalDate.now();
		this.price = price;
	}
	
	public Pens(int stock) {
		super();
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInkColor() {
		return inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDate getListingDate() {
		return listingDate;
	}

	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount=discount;
	}

	@Override
	public String toString() {
		return "Pens [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor
				+ ", material=" + material + ", stock=" + stock + ", updateDate=" + updateDate + ", listingDate="
				+ listingDate + ", price=" + price + ", discount=" + discount + "]";
	}
	
}
