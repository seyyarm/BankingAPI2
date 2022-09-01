package com.revature.repository.DTO;

import java.util.Objects;

public class EmployeeDTO {
	private Integer employee_id;
	private String employee_role;
	private Integer user_id;
	
	public EmployeeDTO(Integer employee_id, String employee_role, Integer user_id) {
		super();
		this.employee_id = employee_id;
		this.employee_role = employee_role;
		this.user_id = user_id;
	}
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_role() {
		return employee_role;
	}
	public void setEmployee_role(String employee_role) {
		this.employee_role = employee_role;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employee_id, employee_role, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(employee_id, other.employee_id) && Objects.equals(employee_role, other.employee_role)
				&& Objects.equals(user_id, other.user_id);
	}
	@Override
	public String toString() {
		return "EmployeeDTO [employee_id=" + employee_id + ", employee_role=" + employee_role + ", user_id=" + user_id
				+ "]";
	}
	
	
	

}
