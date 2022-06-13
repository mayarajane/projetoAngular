import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalheTurmaComponent } from './detalhe-turma.component';

describe('DetalheTurmaComponent', () => {
  let component: DetalheTurmaComponent;
  let fixture: ComponentFixture<DetalheTurmaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalheTurmaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalheTurmaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
