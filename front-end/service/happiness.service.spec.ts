import { TestBed } from '@angular/core/testing';

import { HappinessService } from './happiness.service';

describe('HappinessService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HappinessService = TestBed.get(HappinessService);
    expect(service).toBeTruthy();
  });
});
