package com.mastery.java.task.dto;

import com.mastery.java.task.model.Gender;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDto {

    private String firstName;
    private String lastname;
    private Long departmentId;
    private String jobTitle;
    private Gender gender;


}
