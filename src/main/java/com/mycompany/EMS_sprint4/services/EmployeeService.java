package com.mycompany.EMS_sprint4.services;

import com.mycompany.EMS_sprint4.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService extends CrudRepository<Employee, Integer> {

}
