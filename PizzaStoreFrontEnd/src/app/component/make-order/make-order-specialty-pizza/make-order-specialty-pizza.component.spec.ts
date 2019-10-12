import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderSpecialtyPizzaComponent } from './make-order-specialty-pizza.component';

describe('MakeOrderSpecialtyPizzaComponent', () => {
  let component: MakeOrderSpecialtyPizzaComponent;
  let fixture: ComponentFixture<MakeOrderSpecialtyPizzaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderSpecialtyPizzaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderSpecialtyPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
