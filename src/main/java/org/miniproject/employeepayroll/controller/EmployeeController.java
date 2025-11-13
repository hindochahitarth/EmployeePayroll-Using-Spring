package org.miniproject.employeepayroll.controller;

import org.miniproject.employeepayroll.entity.Employee;
import org.miniproject.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        return employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
         employeeService.deleteEmployee(id);
    }
    @GetMapping("/salary/{salary}")
    public List<Employee> getEmployeesBySalary(@PathVariable Double salary){
        return employeeService.getEmployeesBySalary(salary);
    }
    @GetMapping("/salary/greater/{salary}")
    public  List<Employee> getEmployeesBySalaryGreaterThan(@PathVariable Double salary){
        return employeeService.getEmployeesBySalaryGreaterThan(salary);
    }
    @GetMapping("/salary/less/{salar}")
    public List<Employee> getEmployeesBySalaryLessThan(@PathVariable Double salar){
        return employeeService.getEmployeesBySalaryLessThan(salar);
    }
    @GetMapping("/salary/between/{min}/{max}")
    public List<Employee> getEmployeesBySalaryBetween(@PathVariable Double min, @PathVariable Double max){
        return employeeService.findBySalaryBetween(min, max);
    }
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department){
        return employeeService.getAllEmployeesByDepartment(department);

    }
    @GetMapping("/department/{department}/salary/{salary}")
    public List<Employee> getEmployeesDepartmentAndSalary(@PathVariable String department,@PathVariable Double salary)
    {
        return employeeService.getAllEmployeesByDepartmentAndSalary(department, salary);
    }

}
