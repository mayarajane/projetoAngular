import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Turma } from '../turma';
import { TurmaService } from '../turma.service';

@Component({
  selector: 'app-create-turma',
  templateUrl: './create-turma.component.html',
  styleUrls: ['./create-turma.component.css']
})
export class CreateTurmaComponent implements OnInit {

  turma: Turma = new Turma();
  submitted = false

  constructor(private turmaService: TurmaService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    //vai chamar um método para gravar informação
    this.gravarTurma()
  }

  gravarTurma(){
    this.turmaService.createTurma(this.turma)
  }


}
