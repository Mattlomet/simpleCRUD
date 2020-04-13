import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/model/student';
import { StudentService } from 'src/app/service/student-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentDetailComponent } from '../student-detail/student-detail.component';
import { timer } from 'rxjs';
import { SelectMultipleControlValueAccessor } from '@angular/forms';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentService) { }

  ngOnInit() {
    this.studentService.getAllStudents().subscribe(data =>{
      this.students = data;
    })
  }

  updateStudent(student :Student){
    this.router.navigate(['/update'],{queryParams:
      {
      id: student.id,
      name: student.name,
      grade: student.grade,  
      currentlyEnrolled: student.currentlyEnrolled,  
      gpa: student.gpa
    }  
    });
  }


  deleteStudent(id: number){
    this.studentService.deleteStudent(id);
    this.students.forEach((student,index)=>{
      console.log(this.students)
      if(student.id == id){
        this.students.splice(index,1)
      }
    })
  }

}
