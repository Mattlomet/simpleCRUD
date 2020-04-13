import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentListComponent } from './component/student-list/student-list.component';
import { StudentDetailComponent } from './component/student-detail/student-detail.component';


const routes: Routes = [
  {path: '', component: StudentListComponent},
  {path: 'create', component: StudentDetailComponent},
  {path: 'update', component: StudentDetailComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
