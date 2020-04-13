import { Component, OnInit, Injectable } from '@angular/core';
import { Student } from 'src/app/model/student';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from 'src/app/service/student-service.service';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  student: Student;
  update: Boolean = false;
  submitButton: String = "Submit"

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentService
  ) { 
    this.student = new Student();
  }

  ngOnInit() {
    if (this.router.url != "/create") {
      this.update == true;
      var obj = {
        id: this.route.snapshot.queryParamMap.get("id"),
        name: this.route.snapshot.queryParamMap.get("name"),
        grade: this.route.snapshot.queryParamMap.get("grade"),
        currentlyEnrolled: this.route.snapshot.queryParamMap.get("currentlyEnrolled"),
        gpa: this.route.snapshot.queryParamMap.get("gpa")}
      this.student = new Student(
        obj
        );
      this.submitButton = "Update Student"
    }
  }

  onSubmit(){
    //if component is being used for updating an existing student this will triggle this if statement
    if (this.update) {
      
    }else{
      this.studentService.createStudent(this.student).subscribe(result => this.routeToStudentList());
    }
  }

  routeToStudentList(){
    this.router.navigate(['/'])
  }

}
