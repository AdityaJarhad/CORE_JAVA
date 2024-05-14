package com.app.core;

import java.sql.Date;

public class Voters {
//	id | first_name | last_name | email | password | dob | status | role
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String passwd;
	private Date dob;
	private boolean status;
	private String role;
	
	public Voters(int id, String fname, String lname, String email, String passwd, Date dob, boolean status,
			String role) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.passwd = passwd;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Voters [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", passwd=" + passwd
				+ ", dob=" + dob + ", status=" + status + ", role=" + role + "]";
	}
	
	
	
}
