package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GradingExaminations {
	
	@Id
	private String examCode;
	private String description;
	private Date date;
	
	public GradingExaminations() {
		super();
	}

	public GradingExaminations(String examCode, String description, Date date) {
		super();
		this.examCode = examCode;
		this.description = description;
		this.date = date;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GradingExaminations [examCode=" + examCode + ", description=" + description + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examCode == null) ? 0 : examCode.hashCode());
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
		GradingExaminations other = (GradingExaminations) obj;
		if (examCode == null) {
			if (other.examCode != null)
				return false;
		} else if (!examCode.equals(other.examCode))
			return false;
		return true;
	}
	

}
