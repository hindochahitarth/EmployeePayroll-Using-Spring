package org.miniproject.employeepayroll.controller;

import jakarta.validation.Valid;
import org.miniproject.employeepayroll.entity.Employee;
import org.miniproject.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "add";   // return to form if errors
        }

        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee emp = employeeService.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "update";
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(
            @PathVariable Long id,
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "update";   // return to update form if errors
        }

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
    public String getEmployeesBySalaryGreaterThan(@PathVariable Double salary, Model model) {
        model.addAttribute("employees", employeeService.getEmployeesBySalaryGreaterThan(salary));
        return "index";
    }

    @GetMapping("/salary/less/{salary}")
    public String getEmployeesBySalaryLessThan(@PathVariable Double salary, Model model) {
        model.addAttribute("employees", employeeService.getEmployeesBySalaryLessThan(salary));
        return "index";
    }

    @GetMapping("/salary/between/{min}/{max}")
    public String getEmployeesBySalaryBetween(@PathVariable Double min, @PathVariable Double max, Model model) {
        model.addAttribute("employees", employeeService.findBySalaryBetween(min, max));
        return "index";
    }

    // ===========================
    // Queries by department
    // ===========================

    @GetMapping("/department/{department}")
    public String getEmployeesByDepartment(@PathVariable String department, Model model) {
        model.addAttribute("employees", employeeService.getAllEmployeesByDepartment(department));
        return "index";
    }

    @GetMapping("/department/{department}/salary/{salary}")
    public String getEmployeesDepartmentAndSalary(
            @PathVariable String department,
            @PathVariable Double salary,
            Model model) {

        model.addAttribute("employees", employeeService.getAllEmployeesByDepartmentAndSalary(department, salary));
        return "index";
    }
}
