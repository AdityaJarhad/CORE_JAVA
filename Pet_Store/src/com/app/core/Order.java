package com.app.core;

import java.util.Objects;

public class Order {
//	orderId, petId, quantity, status
	private static int o;
	private int orderId;
	private int petId;
	private int qty;
	private Status status;
	
	static {
		o=1;
	}

	public Order(int petId, int qty, Status status) {
		super();
		this.orderId = o++;
		this.petId = petId;
		this.qty = qty;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", petId=" + petId + ", qty=" + qty + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, petId, qty, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return orderId == other.orderId && petId == other.petId && qty == other.qty && status == other.status;
	}
	
	
}
