package com.ITP.IFKFbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
		@Id
		@Column(name = "userId")
		 private Long userId;
		
		@Column(name = "password")
		 private String password;

		@Column(name = "role")
		 private String role;
		
		public User() {
			
		}
		

		public User(Long userId, String password, String role) {
			super();
			this.userId = userId;
			this.password = password;
			this.role = role;
		}


		public Long getUserId() {
			return userId;
		}


		public void setUserId(Long userId) {
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

