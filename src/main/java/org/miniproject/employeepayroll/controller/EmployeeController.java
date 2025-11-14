package org.miniproject.employeepayroll.controller;

import org.miniproject.employeepayroll.entity.Employee;
import org.miniproject.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // ===========================
    // Basic CRUD
    // ===========================

    @GetMapping
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "index"; // index.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add"; // add.html
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee emp = employeeService.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "update"; // update.html
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    // ===========================
    // Queries by salary
    // ===========================



    @GetMapping("/salary/{salary}")
    public String getEmployeesBySalary(@PathVariable Double salary, Model model) {
        model.addAttribute("employees", employeeService.getEmployeesBySalary(salary));
        return "index";
    }


    @GetMapping("/salary/greater/{salary}")
    public String getEmployeesBySalaryGreaterThan(@PathVariable Double salary, Model model){
        List<Employee> employees = employeeService.getEmployeesBySalaryGreaterThan(salary);
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/salary/less/{salary}")
    public String getEmployeesBySalaryLessThan(@PathVariable Double salary, Model model){
        List<Employee> employees = employeeService.getEmployeesBySalaryLessThan(salary);
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/salary/between/{min}/{max}")
    public String getEmployeesBySalaryBetween(@PathVariable Double min, @PathVariable Double max, Model model){
        List<Employee> employees = employeeService.findBySalaryBetween(min, max);
        model.addAttribute("employees", employees);
        return "index";
    }

    // ===========================
    // Queries by department
    // ===========================

    @GetMapping("/department/{department}")
    public String getEmployeesByDepartment(@PathVariable String department, Model model){
        List<Employee> employees = employeeService.getAllEmployeesByDepartment(department);
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/department/{department}/salary/{salary}")
    public String getEmployeesDepartmentAndSalary(@PathVariable String department,@PathVariable Double salary, Model model){
        List<Employee> employees = employeeService.getAllEmployeesByDepartmentAndSalary(department, salary);
        model.addAttribute("employees", employees);
        return "index";
    }
}
