package com.app.core;

import java.time.LocalDate;

public class Customer {
//1.Customer should be assigned system generated (auto increment) customer id : int
//Store - first name, last name email(string),password(string),registrationAmount(double),
//	dob(LocalDate),plan(ServicePlan : enum)
//Unique ID - email (2 customers CAN NOT have SAME email id)

	private int UID;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private double registrationAmount;
	private LocalDate dob;
	private ServicePlan plan;
	static int id = 1;

	public Customer(String firstname, String lastname, String email, String password, double registrationAmount,
			LocalDate dob, ServicePlan plan) {
		UID = id++;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

//	add overloaded cnstr : , to wrap pk (email)
	public Customer(String email) {
		super();
		this.email = email;
	}

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public void setRegistrationAmount(double registrationAmount) {
		this.registrationAmount = registrationAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public ServicePlan getPlan() {
		return plan;
	}

	public void setPlan(ServicePlan plan) {
		this.plan = plan;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Customer.id = id;
	}

	//	add toString to get customer details
	@Override
	public String toString() {
		return "User ID : " + id + " firstname : " + firstname + " lastname : " + lastname + "Email ID : " + email
				+ " Password : " + password + " registrationAmount : " + registrationAmount + " Birth date : " + dob
				+ " ServicePlan : " + plan;
	}
	

//	override objects equal method to check email (PK)
	@Override
	public boolean equals(Object obj) {
		System.out.println("In object class override equal method");
		if (obj instanceof Customer) {
			Customer c = (Customer) obj;
			return this.email.equals(c.email);
		}
		return false;
	}

}
