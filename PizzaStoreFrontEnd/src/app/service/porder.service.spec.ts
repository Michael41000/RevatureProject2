import { TestBed } from '@angular/core/testing';

import { PorderService } from './porder.service';

describe('PorderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PorderService = TestBed.get(PorderService);
    expect(service).toBeTruthy();
  });
});
