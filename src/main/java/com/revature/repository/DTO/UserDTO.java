package com.revature.repository.DTO;

import java.util.Objects;

public class UserDTO {
	protected Integer user_id;
	protected String username;
	protected String password;
	protected String fullname;
	protected String phone;
	protected String adress;
	protected String email;
	public UserDTO(Integer user_id, String username, String password, String fullname, String phone, String adress,
			String email) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.adress = adress;
		this.email = email;
	}
	public UserDTO() {
		super();
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adress, email, fullname, password, phone, user_id, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(email, other.email)
				&& Objects.equals(fullname, other.fullname) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(user_id, other.user_id)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", username=" + username + ", password=" + password + ", fullname="
				+ fullname + ", phone=" + phone + ", adress=" + adress + ", email=" + email + "]";
	}
	
	

}
