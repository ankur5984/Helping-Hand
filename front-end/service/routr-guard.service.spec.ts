import { TestBed } from '@angular/core/testing';

import { RoutrGuardService } from './routr-guard.service';

describe('RoutrGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RoutrGuardService = TestBed.get(RoutrGuardService);
    expect(service).toBeTruthy();
  });
});
