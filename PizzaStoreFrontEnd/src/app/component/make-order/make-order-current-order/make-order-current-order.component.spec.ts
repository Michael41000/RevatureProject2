import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderCurrentOrderComponent } from './make-order-current-order.component';

describe('MakeOrderCurrentOrderComponent', () => {
  let component: MakeOrderCurrentOrderComponent;
  let fixture: ComponentFixture<MakeOrderCurrentOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderCurrentOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderCurrentOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
