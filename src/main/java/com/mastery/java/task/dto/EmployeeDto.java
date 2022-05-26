package com.mastery.java.task.dto;

import com.mastery.java.task.model.EmployeeEntity;
import com.mastery.java.task.model.Gender;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastname;
    private Long departmentId;
    private String jobTitle;
    private Gender gender;

    public static EmployeeDto create(EmployeeEntity employeeEntity) {
        return EmployeeDto.builder()
                .id(employeeEntity.getEmployee_id())
                .firstName(employeeEntity.getFirst_name())
                .lastname(employeeEntity.getLast_name())
                .departmentId(employeeEntity.getDepartment_id())
                .jobTitle(employeeEntity.getJob_title())
                .gender(employeeEntity.getGender())
                .build();

    }
}
