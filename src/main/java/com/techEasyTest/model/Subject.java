package com.techEasyTest.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date created;
	@Temporal(TemporalType.DATE)
	private Date modified;
	
	private int status;

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Date getCreated() {
		return created;
	}

	protected void setCreated(Date created) {
		this.created = created;
	}

	protected Date getModified() {
		return modified;
	}

	protected void setModified(Date modified) {
		this.modified = modified;
	}

	protected int getStatus() {
		return status;
	}

	protected void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", created=" + created + ", modified=" + modified + ", status="
				+ status + "]";
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
