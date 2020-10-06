package com.ITP.IFKFbackend.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "instructor")


public class Instructor {
	@Id
	@Column(name = "instructorId")
	 private Long  instructorId;
	
	@Column(name = "name")
	 private String name;
	
	@Column(name = "gender")
	 private String gender;
	
	@Column(name = "address")
	 private String address;
	
	@Column(name = "email")
	 private String email;
	
	@Column(name = "nic")
	 private String nic;
	
	@Column(name = "dob")
	 private Date dob;
	
	@Column(name = "session")
	 private String session;
	
	@Column(name = "phoneNo")
	 private String phoneNo;
	
	@Column(name = "qualifications")
	 private String qualifications;
	
	@Column(name = "experience")
	 private String experience;


	 
	 
	 public Instructor() {
		 
	 }




	public Instructor(Long instructorId ,String name, String gender, String address, String email, String nic, Date dob,
			String session, String phoneNo, String qualifications, String experience) {
		super();
		
		this.instructorId =instructorId;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.nic = nic;
		this.dob = dob;
		this.session = session;
		this.phoneNo = phoneNo;
		this.qualifications = qualifications;
		this.experience = experience;
	}




	public Long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Long instructorId) {
		this.instructorId = instructorId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}



}
