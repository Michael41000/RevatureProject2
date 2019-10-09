import { TestBed } from '@angular/core/testing';

import { SignupcontrollerService } from './signupcontroller.service';

describe('SignupcontrollerService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SignupcontrollerService = TestBed.get(SignupcontrollerService);
    expect(service).toBeTruthy();
  });
});
