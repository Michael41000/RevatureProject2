import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderStoresComponent } from './make-order-stores.component';

describe('MakeOrderStoresComponent', () => {
  let component: MakeOrderStoresComponent;
  let fixture: ComponentFixture<MakeOrderStoresComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderStoresComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderStoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
