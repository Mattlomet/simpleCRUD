import { Student } from './student';

describe('Student', () => {
  it('should create an instance', () => {
    expect(new Student()).toBeTruthy();
  });

  it('should allow values in constructor',()=>{
    
    let student = new Student({
      id: 1,
      name: "name",
      grade: 10,
      currentlyEnrolled: true,
      GPA: 4.00
    });

    expect(student.name).toEqual("name");
    expect(student.currentlyEnrolled).toEqual(true);

  })


});
