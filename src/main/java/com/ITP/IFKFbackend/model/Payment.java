package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private Long paymentID;
	private String studentID;
	private String studentName;
	private double amount;
	private String session;
	private String sessionTime;
	private String paymentStatus;
	private String sessionId;
	
	public Payment() {
		super();
	}

	public Payment(Long paymentID, String studentID, String studentName, double amount, String session,
			String sessionTime, String paymentStatus, String sessionId) {
		super();
		this.paymentID = paymentID;
		this.studentID = studentID;
		this.studentName = studentName;
		this.amount = amount;
		this.session = session;
		this.sessionTime = sessionTime;
		this.paymentStatus = paymentStatus;
		this.sessionId = sessionId;
	}

	public Long getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Long paymentID) {
		this.paymentID = paymentID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paymentID == null) ? 0 : paymentID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (paymentID == null) {
			if (other.paymentID != null)
				return false;
		} else if (!paymentID.equals(other.paymentID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", studentID=" + studentID + ", studentName=" + studentName
				+ ", amount=" + amount + ", session=" + session + ", sessionTime=" + sessionTime + ", paymentStatus="
				+ paymentStatus + ", sessionId=" + sessionId + "]";
	}
	
	
	
	
	
}
