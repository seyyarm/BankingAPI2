package com.revature.services.models;

import java.util.Objects;

public abstract class User {
	protected Integer userid;
	protected String username;
	protected String password;
	protected String fullname;
	protected String phone;
	protected String adress;
	protected String email;
	protected int user_type_id;

	
	public User(Integer userid, String username, String password, String fullname, String phone, String adress,
			String email, int user_type_id) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.adress = adress;
		this.email = email;
		this.user_type_id = user_type_id;
	}


	public Integer getUserid() {
		return userid;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
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


	public int getUser_type_id() {
		return user_type_id;
	}


	public void setUser_type_id(int user_type_id) {
		this.user_type_id = user_type_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(adress, email, fullname, password, phone, user_type_id, userid, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(email, other.email)
				&& Objects.equals(fullname, other.fullname) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && user_type_id == other.user_type_id
				&& Objects.equals(userid, other.userid) && Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", phone=" + phone + ", adress=" + adress + ", email=" + email + ", user_type_id=" + user_type_id
				+ "]";
	}
	
	

}
