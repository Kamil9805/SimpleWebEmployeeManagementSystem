package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.CreateEmployeeDto;
import com.mastery.java.task.dto.EmployeeDto;
import com.mastery.java.task.model.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mastery.java.task.model.Gender.MALE;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public CreateEmployeeDto addEmployee(CreateEmployeeDto createEmployeeDto) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirst_name(createEmployeeDto.getFirstName());
        employee.setLast_name(createEmployeeDto.getLastname());
        employee.setDepartment_id(createEmployeeDto.getDepartmentId());
        employee.setJob_title(createEmployeeDto.getJobTitle());

        employeeDao.save(employee);
        return createEmployeeDto;
    }

    public Page<EmployeeDto> getAllEmployee(Pageable pageable) {
        List<EmployeeEntity> employees = employeeDao.findAll();
        int pageS = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startIt = currentPage * pageS;
        List<EmployeeEntity> result;

        if (employees.size() < startIt) {
            result = List.of();
        } else {
            int toIndex = Math.min(startIt + pageS, employees.size());
            result = employees.subList(startIt, toIndex);
        }

        List<EmployeeDto> collect = result.stream()
                .map(EmployeeDto::create)
                .collect(Collectors.toUnmodifiableList());
        return new PageImpl<>(collect, PageRequest.of(currentPage, pageS), employees.size());
    }

   public EmployeeEntity getEmployeeById(Long id) {
        Optional<EmployeeEntity> optional = employeeDao.findById(id);
        EmployeeEntity employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id:: " + id);
        }
        return employee;
    }

    public void deleteEmployee(Long id) {
        if(employeeDao.existsById(id)){
            employeeDao.deleteById(id);
        }
    }

    @PostConstruct
    public void init() {
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());
        addEmployee(CreateEmployeeDto.builder().firstName("Jan").lastname("Kowalski").departmentId(5L).jobTitle("ABCDDS").gender(MALE).build());

    }
}
