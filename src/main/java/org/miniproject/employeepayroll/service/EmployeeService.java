package org.miniproject.employeepayroll.service;

import org.miniproject.employeepayroll.entity.Employee;
import org.miniproject.employeepayroll.exception.ResourceNotFoundException;
import org.miniproject.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CREATE NEW EMPLOYEE
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // FIND ALL EMPLOYEES

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public Employee updateEmployee(Long id,Employee employee) {
        Employee emp = getEmployeeById(id);
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setDepartment(employee.getDepartment());
        emp.setEmail(employee.getEmail());
        return employeeRepository.save(emp);
    }
    public void deleteEmployee(Long id) {
        Employee emp = getEmployeeById(id);
        employeeRepository.delete(emp);
    }
    public List<Employee> getEmployeesBySalary(Double salary){
        return employeeRepository.findBySalary(salary);
    }
    public List<Employee> getEmployeesBySalaryGreaterThan(Double salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
    public List<Employee> getEmployeesBySalaryLessThan(Double salary){
        return employeeRepository.findBySalaryLessThan(salary);
    }
    public List<Employee> getAllEmployeesByDepartment(String department){
        return employeeRepository.findByDepartment(department);
    }
    public List<Employee> getAllEmployeesByDepartmentAndSalary(String department, Double salary){
        return employeeRepository.findByDepartmentAndSalary(department, salary);
    }
    public List<Employee> findBySalaryBetween(Double salary1 ,Double salary2)
    {
        return employeeRepository.findBySalaryBetween(salary1, salary2);
    }
}
