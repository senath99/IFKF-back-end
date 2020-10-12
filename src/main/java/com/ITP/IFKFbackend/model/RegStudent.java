package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Component
@Entity
public class RegStudent{
	
	@Id
	@GeneratedValue
	private Long enrollId;
	private Long studId;
	private String weight;
	private String name;
	private Date dob;
	private String kyu;

	public RegStudent() {
		super();
	}
	
	public RegStudent(Long enrollId, Long studId, String weight, String name, Date dob, String kyu) {
		super();
		this.enrollId = enrollId;
		this.studId = studId;
		this.weight = weight;
		this.name = name;
		this.dob = dob;
		this.kyu = kyu;
	}

	public Long getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(Long enrollId) {
		this.enrollId = enrollId;
	}

	public Long getStudId() {
		return studId;
	}

	public void setStudId(Long studId) {
		this.studId = studId;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getKyu() {
		return kyu;
	}

	public void setKyu(String kyu) {
		this.kyu = kyu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studId == null) ? 0 : studId.hashCode());
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
		RegStudent other = (RegStudent) obj;
		if (studId == null) {
			if (other.studId != null)
				return false;
		} else if (!studId.equals(other.studId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegStudent [enrollId=" + enrollId + ", studId=" + studId + ", weight=" + weight + ", name=" + name
				+ ", dob=" + dob + ", kyu=" + kyu + "]";
	}

}