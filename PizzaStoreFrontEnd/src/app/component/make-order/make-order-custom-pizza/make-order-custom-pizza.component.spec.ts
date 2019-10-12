import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderCustomPizzaComponent } from './make-order-custom-pizza.component';

describe('MakeOrderCustomPizzaComponent', () => {
  let component: MakeOrderCustomPizzaComponent;
  let fixture: ComponentFixture<MakeOrderCustomPizzaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderCustomPizzaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderCustomPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
