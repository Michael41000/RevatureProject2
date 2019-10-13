import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeOrderFavoriteComponent } from './make-order-favorite.component';

describe('MakeOrderFavoriteComponent', () => {
  let component: MakeOrderFavoriteComponent;
  let fixture: ComponentFixture<MakeOrderFavoriteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeOrderFavoriteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeOrderFavoriteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
