package com.gamblingestablishments.GamblingEstablishments.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Establishment {
	private static final AtomicInteger count = new AtomicInteger(0);
	private int id;
	@NotEmpty(message = "ERROR! Name must be entered")
	private String name;
	@NotEmpty(message = "ERROR! Location must be entered")
	private String location;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = count.incrementAndGet();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Establishment [id=" + id + ", name=" + name + ", location=" + location + ", createdDate=" + createdDate
				+ "]";
	}

}
