package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Results {
	
	@Id
	@GeneratedValue
	private Long resultsId;
	private String studentId;
	private String examCode;
	private Date date;
	private int kihon;
	private int combinations;
	private int kata;
	private int kumite;
	private int generalKnowledge;
	private int theory;
	
	public Results() {
		super();
	}

	public Results(Long resultsId, String studentId, String examCode, Date date, int kihon, int combinations, int kata,
			int kumite, int generalKnowledge, int theory) {
		super();
		this.resultsId = resultsId;
		this.studentId = studentId;
		this.examCode = examCode;
		this.date = date;
		this.kihon = kihon;
		this.combinations = combinations;
		this.kata = kata;
		this.kumite = kumite;
		this.generalKnowledge = generalKnowledge;
		this.theory = theory;
	}

	public Long getResultsId() {
		return resultsId;
	}

	public void setResultsId(Long resultsId) {
		this.resultsId = resultsId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getKihon() {
		return kihon;
	}

	public void setKihon(int kihon) {
		this.kihon = kihon;
	}

	public int getCombinations() {
		return combinations;
	}

	public void setCombinations(int combinations) {
		this.combinations = combinations;
	}

	public int getKata() {
		return kata;
	}

	public void setKata(int kata) {
		this.kata = kata;
	}

	public int getKumite() {
		return kumite;
	}

	public void setKumite(int kumite) {
		this.kumite = kumite;
	}

	public int getGeneralKnowledge() {
		return generalKnowledge;
	}

	public void setGeneralKnowledge(int generalKnowledge) {
		this.generalKnowledge = generalKnowledge;
	}

	public int getTheory() {
		return theory;
	}

	public void setTheory(int theory) {
		this.theory = theory;
	}

	@Override
	public String toString() {
		return "Results [resultsId=" + resultsId + ", studentId=" + studentId + ", examCode=" + examCode + ", date="
				+ date + ", kihon=" + kihon + ", combinations=" + combinations + ", kata=" + kata + ", kumite=" + kumite
				+ ", generalKnowledge=" + generalKnowledge + ", theory=" + theory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resultsId == null) ? 0 : resultsId.hashCode());
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
		Results other = (Results) obj;
		if (resultsId == null) {
			if (other.resultsId != null)
				return false;
		} else if (!resultsId.equals(other.resultsId))
			return false;
		return true;
	}

}
