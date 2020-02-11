package com.sai.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
public class HallTicket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="hallticket_no")
	private String hallticketNumber;
	
	@Column(name="createdOn")
	@Transient
	private Timestamp creationOn;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="hallTicket")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getHallticketNumber() {
		return hallticketNumber;
	}

	public void setHallticketNumber(String hallticketNumber) {
		this.hallticketNumber = hallticketNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreationOn() {
		return creationOn;
	}

	public void setCreationOn(Timestamp creationOn) {
		this.creationOn = creationOn;
	}

    	
	
}
