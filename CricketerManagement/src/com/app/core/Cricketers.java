package com.app.core;

import java.util.Objects;

public class Cricketers {
//	String name,int age,String email_id,String Phone,int rating
	private String name;
	private int age;
	private String email;
	private String phone;
	private Integer rating;
	
	public Cricketers(String name, int age, String email, String phone, Integer rating) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, name, phone, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cricketers other = (Cricketers) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && rating == other.rating;
	}

	@Override
	public String toString() {
		return "Cricketers [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + ", rating="
				+ rating + "]";
	}
	
}
