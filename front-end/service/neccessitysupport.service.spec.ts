import { TestBed } from '@angular/core/testing';

import { NeccessitysupportService } from './neccessitysupport.service';

describe('NeccessitysupportService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NeccessitysupportService = TestBed.get(NeccessitysupportService);
    expect(service).toBeTruthy();
  });
});
