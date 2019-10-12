import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagespecpizzaComponent } from './managespecpizza.component';

describe('ManagespecpizzaComponent', () => {
  let component: ManagespecpizzaComponent;
  let fixture: ComponentFixture<ManagespecpizzaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagespecpizzaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagespecpizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
