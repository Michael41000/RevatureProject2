import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderUpdateCustomPizzaComponent } from './make-order-update-custom-pizza.component';

describe('MakeOrderUpdateCustomPizzaComponent', () => {
  let component: MakeOrderUpdateCustomPizzaComponent;
  let fixture: ComponentFixture<MakeOrderUpdateCustomPizzaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderUpdateCustomPizzaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderUpdateCustomPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
