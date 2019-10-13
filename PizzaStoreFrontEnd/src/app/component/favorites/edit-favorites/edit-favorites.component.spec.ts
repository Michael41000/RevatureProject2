import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditFavoritesComponent } from './edit-favorites.component';

describe('EditFavoritesComponent', () => {
  let component: EditFavoritesComponent;
  let fixture: ComponentFixture<EditFavoritesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditFavoritesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditFavoritesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
