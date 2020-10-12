package com.ITP.IFKFbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Attendance {


	@Id
	@GeneratedValue
	private Long attendanceID;
	
	private int noOfdays;
	
	private String stuId;
	
	

	public Attendance() {
		super();
	
  }


	public Attendance(Long attendanceID, int noOfdays, String stuId) {
		super();
		this.attendanceID = attendanceID;
		this.noOfdays = noOfdays;
		this.stuId = stuId;
	}

	public Long getAttendanceID() {
		
		return attendanceID;
	}

	public Long getAttendanceID1() {
		return attendanceID;
	}


	public void setAttendanceID(Long attendanceID) {
		this.attendanceID = attendanceID;
	}


	public int getNoOfdays() {
		return noOfdays;
	}


	public void setNoOfdays(int noOfdays) {
		this.noOfdays = noOfdays;
	}



	public String getStuId() {
		return stuId;
	}



	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
		
}




