import { TestBed } from '@angular/core/testing';

import { PsizeService } from './psize.service';

describe('PsizeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PsizeService = TestBed.get(PsizeService);
    expect(service).toBeTruthy();
  });
});
