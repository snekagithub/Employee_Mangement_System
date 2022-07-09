package com.mycompany.EMS_sprint4;

import com.mycompany.EMS_sprint4.controllers.EmployeeController;
import com.mycompany.EMS_sprint4.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

    @Autowired
    EmployeeController employeeController;

    @Test
    public void testCreateReadDelete()throws ValidationException{
        Employee employee = new Employee("Vineeth","7686667687","HR","vineeth@gmail.com","coimbatore","Employee");
        try {
            Employee savedEmployee = employeeController.addEmployee(employee);
        }catch (javax.xml.bind.ValidationException e) {
            throw new RuntimeException(e);
        }

        Iterable<Employee> employeeList = employeeController.listEmployee();
        Assertions.assertThat(employeeList).first().hasFieldOrPropertyWithValue("empName", "Vineeth");

        employeeController.deleteEmployee(employee.getEmpID());
        Assertions.assertThat(employeeController.listEmployee()).isEmpty();

    }

    @Test(expected = ValidationException.class)
    public void checkingWrongUrl() {
        employeeController.enteredWrongUrl();

    }

}