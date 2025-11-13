package org.miniproject.employeepayroll.repository;

import org.miniproject.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findBySalary(Double salary);
    List<Employee> findBySalaryGreaterThan(Double salary);
    List<Employee> findBySalaryLessThan(Double salary);
    List<Employee> findBySalaryBetween(Double salary, Double salary2);
    List<Employee> findByDepartment(String departmentName);
    List<Employee> findByDepartmentAndSalary(String departmentName, Double salary);

}
