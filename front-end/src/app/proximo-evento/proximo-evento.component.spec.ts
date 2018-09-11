import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProximoEventoComponent } from './proximo-evento.component';

describe('ProximoEventoComponent', () => {
  let component: ProximoEventoComponent;
  let fixture: ComponentFixture<ProximoEventoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProximoEventoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProximoEventoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
