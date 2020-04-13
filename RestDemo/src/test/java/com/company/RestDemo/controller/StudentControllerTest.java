package com.company.RestDemo.controller;

import com.company.RestDemo.model.Student;
import com.company.RestDemo.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import java.math.BigDecimal;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    private ObjectMapper mapper = new ObjectMapper();

    Student mockStudent;
    Student mockStudentWithId;

    String inputJson;
    String outJson;

    @Before
    public void setUp() throws JsonProcessingException {
        BigDecimal gpa = new BigDecimal(String.valueOf(BigDecimal.valueOf(10.00)));

        mockStudent = new Student("testStudent",10,true, gpa);
        mockStudentWithId = new Student("testStudent",10,true, gpa);
        mockStudentWithId.setId(1);

        inputJson = mapper.writeValueAsString(mockStudent);
        outJson = mapper.writeValueAsString(mockStudentWithId);

        setUpStudentServiceMocks();
    }

    @Test
    public void createStudentPost() throws Exception {
        this.mockMvc.perform(post("/student/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andExpect(content().string(outJson));
    }

    @Test
    public void retrieveStudentGet() throws Exception {
        this.mockMvc.perform(get("/student/info/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(outJson));
    }

    public void setUpStudentServiceMocks(){
        doReturn(mockStudentWithId).when(studentService).createStudent(mockStudent);
        doReturn(mockStudentWithId).when(studentService).getStudentById(mockStudentWithId.getId());
    }


}