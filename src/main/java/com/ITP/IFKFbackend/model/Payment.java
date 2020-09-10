package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@Column(name = "paymentId")
	 private Long  paymentId;
	
	@Column(name = "studentId")
	 private String studentId;
	
	@Column(name = "sessionId")
	 private String sessionId;
	
	@Column(name = "name")
	 private String name;
	
	@Column(name = "status")
	 private String status;
	
	public Payment() {
		 
	 }

	public Payment(Long paymentId, String studentId, String sessionId, String name, String status) {
		super();
		this.paymentId = paymentId;
		this.studentId = studentId;
		this.sessionId = sessionId;
		this.name = name;
		this.status = status;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
