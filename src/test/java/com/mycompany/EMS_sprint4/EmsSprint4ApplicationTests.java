package com.mycompany.EMS_sprint4;

import com.mycompany.EMS_sprint4.controllers.EmployeeController;
import com.mycompany.EMS_sprint4.model.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class EmsSprint4ApplicationTests {

	@Autowired
	EmployeeController employeeController;

	@Test
	public void contextLoads() {

		Assert.assertNotNull(employeeController);
	}
}
