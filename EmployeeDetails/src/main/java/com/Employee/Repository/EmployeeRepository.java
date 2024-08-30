package com.Employee.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Employee.Model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByEmployeeId(String employeeId);
}

