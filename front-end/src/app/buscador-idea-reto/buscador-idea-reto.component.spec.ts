import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscadorIdeaRetoComponent } from './buscador-idea-reto.component';

describe('BuscadorIdeaRetoComponent', () => {
  let component: BuscadorIdeaRetoComponent;
  let fixture: ComponentFixture<BuscadorIdeaRetoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuscadorIdeaRetoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscadorIdeaRetoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
