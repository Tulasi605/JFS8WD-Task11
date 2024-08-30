package com.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.Employee.Model.Employee;
import com.Employee.Repository.EmployeeRepository;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public ModelAndView displayAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return new ModelAndView("displayAll", "employees", employees);
    }

    @GetMapping("/display/{employeeId}")
    public ModelAndView displayEmployeeById(@PathVariable("employeeId") String employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        return new ModelAndView("display", "employee", employee);
    }
}

