package com.mastery.java.task.rest;
import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.CreateEmployeeDto;
import com.mastery.java.task.dto.EmployeeDto;
import com.mastery.java.task.model.EmployeeEntity;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeDao employeeDao) {
        this.employeeService = employeeService;
        this.employeeDao = employeeDao;
    }

    @GetMapping("/simplewebapp")
    public String home(Model model,
                       @RequestParam("employeesPage")Optional<Integer> employeesPage,
                       @RequestParam("employeesSize") Optional<Integer> employeesSize)
    {
        int employeesCurrentPage = employeesPage.orElse(1);
        int employeesPageSize = employeesSize.orElse(10);

        Page<EmployeeDto> employees = employeeService.getAllEmployee(PageRequest.of(employeesCurrentPage-1, employeesPageSize));
        model.addAttribute("employees", employees);

        int totalPages = employees.getTotalPages();
        if (totalPages>0) {
            List<Integer> employeesPageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("employeesPageNumbers", employeesPageNumbers);
        }
        return "home";
    }

    @PostMapping(path = "/add-employee")
    @Transactional
    public String addEmployee(@ModelAttribute CreateEmployeeDto createEmployeeDto, @ModelAttribute("employee") EmployeeEntity employee) {
        employeeService.addEmployee(createEmployeeDto);
        return "redirect:/simplewebapp";
    }

    @PostMapping(path = "/update-employee")
    @Transactional
    public String updateEmployee(@ModelAttribute("employee") EmployeeEntity employee) {
        employeeDao.save(employee);
        return "redirect:/simplewebapp";
    }

    @GetMapping(path = "/save")
    public String getSaveView(Model model) {
        model.addAttribute("newEmployee", new CreateEmployeeDto());
        return "newUser";
    }

    @GetMapping("/showUpdate/{id}")
    @Transactional
    public String showUpdate(@PathVariable(value = "id") Long id, Model model){
        EmployeeEntity employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping(path="/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/simplewebapp";
    }

}
