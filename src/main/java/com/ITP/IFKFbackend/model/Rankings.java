package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rankings {
	
	@Id
	@GeneratedValue
	private Long rankingsId;
	private String studentId;
	private String rank;
	private Date date;
	
	public Rankings() {
		super();
	}

	public Rankings(Long rankingsId, String studentId, String rank, Date date) {
		super();
		this.rankingsId = rankingsId;
		this.studentId = studentId;
		this.rank = rank;
		this.date = date;
	}
	
	public Long getRankingsId() {
		return rankingsId;
	}
	public void setRankingsId(Long rankingsId) {
		this.rankingsId = rankingsId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Rankings [rankingsId=" + rankingsId + ", studentId=" + studentId + ", rank=" + rank + ", date=" + date
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rankingsId ^ (rankingsId >>> 32));
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
		Rankings other = (Rankings) obj;
		if (rankingsId != other.rankingsId)
			return false;
		return true;
	}
	
	

}
