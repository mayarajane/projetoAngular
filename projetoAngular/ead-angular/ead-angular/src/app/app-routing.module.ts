import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateTurmaComponent } from './create-turma/create-turma.component';
import { ListTurmaComponent } from './list-turma/list-turma.component';

const routes: Routes = [
  {
    path: 'turmas', component: ListTurmaComponent
  },
  {
    path: 'adicionar', component:CreateTurmaComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
