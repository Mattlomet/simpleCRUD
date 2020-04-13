package com.company.RestDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message="Name cannot be null!")
    @NotEmpty(message="Name cannot be empty")
    private String name;
    @Min(value=1,message = "Grade should not be lower than one")
    @Max(value=12,message = "Grade should not be higher than twelve")
    private int grade;

    private boolean currentlyEnrolled;

    @DecimalMin(value = "0.00",message = "GPA cannot be lower than 0.00")
    @DecimalMin(value = "4.00",message = "GPA cannot be higher than 4.00")
    private BigDecimal GPA;

    // constructor would be written by @Data but wanted a custom constructor to let id auto generate
    public Student(String name, int grade, boolean currentlyEnrolled, BigDecimal GPA) {
        this.name = name;
        this.grade = grade;
        this.currentlyEnrolled = currentlyEnrolled;
        this.GPA = GPA;
    }

    public Student() {
    }


    // getters and setters taken care of by @Data

    // equals toString and hashcode all replaced by @Data



}