package com.revature.services;

import com.revature.repository.DTO.EmployeeDTO;
import com.revature.services.models.Employee;

public interface EmployeeServiceInterface {
	Employee convertPlanetDto(EmployeeDTO employeeDto);


}
