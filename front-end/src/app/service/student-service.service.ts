import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from '../model/student'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})


export class StudentService {

  private studentGetURL: string;
  private studentGetAllURL: string;
  private studentPostURL: string;
  private studentPutURL: string;
  private studentDeleteURL: string;


  constructor(private http: HttpClient) { 
    this.studentGetURL = 'http://localhost:8080/student/info/';
    this.studentGetAllURL = 'http://localhost:8080/student/all';
    this.studentPostURL = 'http://localhost:8080/student/create';
    this.studentPutURL = 'http://localhost:8080/student/update';
    this.studentDeleteURL = 'http://localhost:8080/student/terminateStudent/';
  }


  public getStudent(id: number): Observable<Student>{
    return this.http.get<Student>(this.studentGetURL+id);
  }

  public getAllStudents(): Observable<Student[]>{
    return this.http.get<Student[]>(this.studentGetAllURL); 
  }

  public createStudent(student: Student): Observable<Student>{
    return this.http.post<Student>(this.studentPostURL,student);
  }

  public updateStudent(student: Student){
    this.http.put<Student>(this.studentPutURL,student).subscribe(
      ()=> console.log("student updated id #%d",student.id)
      );
  }

  public deleteStudent(id: number){
    this.http.delete(this.studentDeleteURL+id).subscribe(
      ()=> console.log("student deleted id #%d",id)
      );
  }

}
