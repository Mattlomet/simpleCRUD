package com.company.RestDemo.service;

import java.util.List;

import com.company.RestDemo.dao.StudentDao;
import com.company.RestDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Component;


@Component
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public Student createStudent(Student student) {
        try {
            return studentDao.save(student);
        }catch (Exception e) {
            throw new IllegalArgumentException("Student object supplied is invalid try again");
        }
    }

    public Student getStudentById(int id){
        if (id <= 0) throw new IllegalArgumentException("invalid student id supplied");

        try{
            return studentDao.getOne(id);
        }catch (Exception e){
            throw new DataRetrievalFailureException("unable to find student with id supplied");
        }
    }

    public List<Student> getAllStudents(){
        try {
            return studentDao.findAll();
        }catch(Exception e){
            throw new DataRetrievalFailureException("unable to retrieve all students");
        }
    }

    public void updateStudent(Student student){
        try{
            Student studentFromDataBase = studentDao.getOne(student.getId());
            studentFromDataBase.setName(student.getName());
            studentFromDataBase.setGrade(student.getGrade());
            studentFromDataBase.setCurrentlyEnrolled(student.isCurrentlyEnrolled());
            studentFromDataBase.setGPA(student.getGPA());
            studentDao.save(student);
        }catch(Exception e){
            throw new IllegalArgumentException("Please recheck data - error in update");
        }

    }

    public void deleteStudentById(int id){
        try{
            studentDao.deleteById(id);
        }catch(Exception e){
            throw new IllegalArgumentException("invalid student id supplied");
        }
    }

}