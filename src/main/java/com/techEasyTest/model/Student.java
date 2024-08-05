package com.techEasyTest.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String address;
	
	@Temporal(TemporalType.DATE)
	private Date created;
	@Temporal(TemporalType.DATE)
	private Date modified;
	
	@ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name="subject_id")
    )
    private Set<Subject> subject;

	
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


	protected String getAddress() {
		return address;
	}


	protected void setAddress(String address) {
		this.address = address;
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


	protected Set<Subject> getSubject() {
		return subject;
	}


	protected void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}


	protected int getStatus() {
		return status;
	}


	protected void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", created=" + created + ", modified="
				+ modified + ", subject=" + subject + ", status=" + status + "]";
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
