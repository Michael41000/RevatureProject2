import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageSpecialtyPizzaComponent } from './manage-specialty-pizza.component';

describe('ManageSpecialtyPizzaComponent', () => {
  let component: ManageSpecialtyPizzaComponent;
  let fixture: ComponentFixture<ManageSpecialtyPizzaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageSpecialtyPizzaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageSpecialtyPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
