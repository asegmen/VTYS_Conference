package com.vtys.vtysdemo.repositories;

import com.vtys.vtysdemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
