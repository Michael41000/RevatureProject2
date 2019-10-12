import { TestBed } from '@angular/core/testing';

import { ToppingTypeService } from './topping-type.service';

describe('ToppingTypeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ToppingTypeService = TestBed.get(ToppingTypeService);
    expect(service).toBeTruthy();
  });
});
