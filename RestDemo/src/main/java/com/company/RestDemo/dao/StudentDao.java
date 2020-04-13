package com.company.RestDemo.dao;
import java.math.BigDecimal;
import java.util.List;


import com.company.RestDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}