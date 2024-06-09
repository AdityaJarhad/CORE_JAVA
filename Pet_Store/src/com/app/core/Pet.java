package com.app.core;

import java.util.Objects;

public class Pet {
//	Pet ( petId, name, category, unitPrice, Statuss)
	private static int p;
	private int petId;
	private String name;
	private Category category;
	private double price;
	private Status status;
	static {
		p=101;
	}
	public Pet(String name, Category category, double price, Status status) {
		super();
		this.petId = p++;
		this.name = name;
		this.category = category;
		this.price = price;
		this.status = status;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", price=" + price + ", Status="
				+ status + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, name, petId, price, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return category == other.category && Objects.equals(name, other.name) && petId == other.petId
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && status == other.status;
	}
	
}
