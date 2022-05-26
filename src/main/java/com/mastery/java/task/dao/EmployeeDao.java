package com.mastery.java.task.dao;

import com.mastery.java.task.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

}
