import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderStoreComponent } from './make-order-store.component';

describe('MakeOrderStoreComponent', () => {
  let component: MakeOrderStoreComponent;
  let fixture: ComponentFixture<MakeOrderStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
