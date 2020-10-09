package com.ITP.IFKFbackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class unregStudent {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	private String nic;
	private Date dob;
	private String weight;
	private String kyu;
	private int phone;
	private String email;
	private String guardianName;
	private int guardianPhone;
	
	public unregStudent() {
		super();
	}

	public unregStudent(Long id, String eventId, String name, String address, String nic, Date dob, String weight,
			String kyu, int phone, String email, String guardianName, int guardianPhone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.nic = nic;
		this.dob = dob;
		this.weight = weight;
		this.kyu = kyu;
		this.phone = phone;
		this.email = email;
		this.guardianName = guardianName;
		this.guardianPhone = guardianPhone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getKyu() {
		return kyu;
	}

	public void setKyu(String kyu) {
		this.kyu = kyu;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGuardianName() {
		return guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	public int getGuardianPhone() {
		return guardianPhone;
	}

	public void setGuardianPhone(int guardianPhone) {
		this.guardianPhone = guardianPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		unregStudent other = (unregStudent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "unregStudent [id=" + id + ", name=" + name + ", address=" + address + ", nic="
				+ nic + ", dob=" + dob + ", weight=" + weight + ", kyu=" + kyu + ", phone=" + phone + ", email=" + email
				+ ", guardianName=" + guardianName + ", guardianPhone=" + guardianPhone + "]";
	}

}