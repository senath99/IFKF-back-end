package com.ITP.IFKFbackend.model;

import java.sql.Date;
import java.time.LocalTime; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Session {
	
	@Id
	@GeneratedValue
	private Long sessionId;
	private Date day;
	private LocalTime stime;
	private LocalTime etime;
	private String venue;
	private String branch;
	private Long instructorId;
	private String instructorName;
	
	public Session() {
		super();
	}

	public Session(Long sessionId, Date day, LocalTime stime, LocalTime etime, String venue, String branch, Long instructorId,
			String instructorName) {
		super();
		this.sessionId = sessionId;
		this.day = day;
		this.stime = stime;
		this.etime = etime;
		this.venue = venue;
		this.branch = branch;
		this.instructorId = instructorId;
		this.instructorName = instructorName;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public LocalTime getStime() {
		return stime;
	}

	public void setStime(LocalTime stime) {
		this.stime = stime;
	}

	public LocalTime getEtime() {
		return etime;
	}

	public void setEtime(LocalTime etime) {
		this.etime = etime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
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
		Session other = (Session) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", day=" + day + ", stime=" + stime + ", etime=" + etime + ", venue="
				+ venue + ", branch=" + branch + ", instructorId=" + instructorId + ", instructorName=" + instructorName
				+ "]";
	}
	
	
	
}

