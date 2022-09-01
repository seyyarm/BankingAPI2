package com.revature.repository.DTO;

import java.util.Objects;

public class TransactionDTO {
	private Integer transact_id;
	private String transact_date;
	private Integer transact_ammount;
	private Integer transact_type;
	private Integer account_id;
	public TransactionDTO(Integer transact_id, String transact_date, Integer transact_ammount, Integer transact_type,
			Integer account_id) {
		super();
		this.transact_id = transact_id;
		this.transact_date = transact_date;
		this.transact_ammount = transact_ammount;
		this.transact_type = transact_type;
		this.account_id = account_id;
	}
	public Integer getTransact_id() {
		return transact_id;
	}
	public void setTransact_id(Integer transact_id) {
		this.transact_id = transact_id;
	}
	public String getTransact_date() {
		return transact_date;
	}
	public void setTransact_date(String transact_date) {
		this.transact_date = transact_date;
	}
	public Integer getTransact_ammount() {
		return transact_ammount;
	}
	public void setTransact_ammount(Integer transact_ammount) {
		this.transact_ammount = transact_ammount;
	}
	public Integer getTransact_type() {
		return transact_type;
	}
	public void setTransact_type(Integer transact_type) {
		this.transact_type = transact_type;
	}
	public Integer getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(account_id, transact_ammount, transact_date, transact_id, transact_type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDTO other = (TransactionDTO) obj;
		return Objects.equals(account_id, other.account_id) && Objects.equals(transact_ammount, other.transact_ammount)
				&& Objects.equals(transact_date, other.transact_date) && Objects.equals(transact_id, other.transact_id)
				&& Objects.equals(transact_type, other.transact_type);
	}
	@Override
	public String toString() {
		return "TransactionDTO [transact_id=" + transact_id + ", transact_date=" + transact_date + ", transact_ammount="
				+ transact_ammount + ", transact_type=" + transact_type + ", account_id=" + account_id + "]";
	}
	

}
