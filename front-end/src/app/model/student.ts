export class Student {
    id: number;
    name: string;
    grade: number;
    currentlyEnrolled: boolean;
    gpa: number;

    constructor(values: Object={}){
        Object.assign(this, values);
    }
}
