import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTurmaComponent } from './create-turma/create-turma.component';
import { DetalheTurmaComponent } from './detalhe-turma/detalhe-turma.component';
import { ListTurmaComponent } from './list-turma/list-turma.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateTurmaComponent,
    DetalheTurmaComponent,
    ListTurmaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
     
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
