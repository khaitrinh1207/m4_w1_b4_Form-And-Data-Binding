package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    List<Employee> employeeList = new ArrayList<>();
    @GetMapping
    public ModelAndView showList(){
        return new ModelAndView("home","employeeList",employeeList);
    }

    @GetMapping("create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","employee1", new Employee());
    }

    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Employee employee){
        employeeList.add(employee);
        return new ModelAndView("redirect:/employee");
    }
}
