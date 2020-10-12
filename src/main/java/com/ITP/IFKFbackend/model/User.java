package com.ITP.IFKFbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")

public class User {
	
		@Id
		@Column(name = "userId",length=50)
		 private String userId;
		
		@Column(name = "password")
		 private String password;

		@Column(name = "role")
		 private String role;
		
		public User() {
			
		}
		

		public User(String userId, String password, String role) {
			super();
			this.userId = userId;
			this.password = password;
			this.role = role;
		}


		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
			this.userId = userId;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}
		
		
		
		
}

