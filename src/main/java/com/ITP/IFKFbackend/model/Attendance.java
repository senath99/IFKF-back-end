package com.ITP.IFKFbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monthlyAttendance")
public class Attendance {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceID;
	
	@Column(name = "Student_ID")
	private String StudentID;
	@Column(name = "week1")
	private boolean week1;
	
	@Column(name = "week2")
	private boolean week2;
	
	@Column(name = "week3")
	private boolean week3;
	
	@Column(name = "week4")
	private boolean week4;
	
	
	

	@Column(name = "Session_ID")
	private String SessionID;
	
	@Column(name = "student_name")
	private String StudentName;
	
	public Attendance() {}

	public Attendance(Long attendanceID, String studentID, boolean week1, boolean week2, boolean week3, boolean week4,
			String sessionID, String studentName) {
		super();
		this.attendanceID = attendanceID;
		StudentID = studentID;
		this.week1 = week1;
		this.week2 = week2;
		this.week3 = week3;
		this.week4 = week4;
		SessionID = sessionID;
		StudentName = studentName;
	}

	public Long getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(Long attendanceID) {
		this.attendanceID = attendanceID;
	}

	public String getStudentID() {
		return StudentID;
	}

	public void setStudentID(String studentID) {
		StudentID = studentID;
	}

	public boolean isWeek1() {
		return week1;
	}

	public void setWeek1(boolean week1) {
		this.week1 = week1;
	}

	public boolean isWeek2() {
		return week2;
	}

	public void setWeek2(boolean week2) {
		this.week2 = week2;
	}

	public boolean isWeek3() {
		return week3;
	}

	public void setWeek3(boolean week3) {
		this.week3 = week3;
	}

	public boolean isWeek4() {
		return week4;
	}

	public void setWeek4(boolean week4) {
		this.week4 = week4;
	}

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	

	
	
	
	
}

