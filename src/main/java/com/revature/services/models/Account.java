package com.revature.services.models;

import java.util.Objects;

public class Account {
	protected Integer account_id;
	protected String account_type;
	protected Integer balance;
	protected String created_On;
	protected boolean is_active;
	protected String acc_number;
	public Account(Integer account_id, String account_type, Integer balance, String created_On, boolean is_active,
			String acc_number) {
		super();
		this.account_id = account_id;
		this.account_type = account_type;
		this.balance = balance;
		this.created_On = created_On;
		this.is_active = is_active;
		this.acc_number = acc_number;
	}
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getCreated_On() {
		return created_On;
	}
	public void setCreated_On(String created_On) {
		this.created_On = created_On;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}
	@Override
	public int hashCode() {
		return Objects.hash(acc_number, account_id, account_type, balance, created_On, is_active);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(acc_number, other.acc_number) && Objects.equals(account_id, other.account_id)
				&& Objects.equals(account_type, other.account_type) && Objects.equals(balance, other.balance)
				&& Objects.equals(created_On, other.created_On) && is_active == other.is_active;
	}
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_type=" + account_type + ", balance=" + balance
				+ ", created_On=" + created_On + ", is_active=" + is_active + ", acc_number=" + acc_number + "]";
	}


}
