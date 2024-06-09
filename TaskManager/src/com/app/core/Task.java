package com.app.core;

import java.time.LocalDate;

public class Task {
//	taskId, taskName, description, taskDate, status, active
	static int cnt = 1;
	private int taskId;
	private String taskName;
	private String discription;
	private LocalDate taskDate;
	private Status status = Status.PENDING;
	private boolean active=true;
	
	public Task(String taskName, String discription, LocalDate taskDate) {
		super();
		this.taskId = cnt++;
		this.taskName = taskName;
		this.discription = discription;
		this.taskDate = taskDate;

	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", discription=" + discription + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]";
	}

	
}