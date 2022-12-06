package com.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Userdto {
		private String username;
		
		@JsonIgnore
		private boolean isLoggedIn;
		private String role;
		public Userdto() {
			super();
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public boolean isLoggedIn() {
			return isLoggedIn;
		}
		public void setLoggedIn(boolean isLoggedIn) {
			this.isLoggedIn = isLoggedIn;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		@Override
		public String toString() {
			return "LoginDto [username=" + username + ", isLoggedIn=" + isLoggedIn + ", role=" + role + "]";
		
		

	}
		
	}

