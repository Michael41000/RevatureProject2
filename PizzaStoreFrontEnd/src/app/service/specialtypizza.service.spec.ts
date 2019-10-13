import { TestBed } from '@angular/core/testing';

import { SpecialtypizzaService } from './specialtypizza.service';

describe('SpecialtypizzaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SpecialtypizzaService = TestBed.get(SpecialtypizzaService);
    expect(service).toBeTruthy();
  });
});
