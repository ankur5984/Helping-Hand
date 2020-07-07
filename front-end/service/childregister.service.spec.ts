import { TestBed } from '@angular/core/testing';

import { ChildregisterService } from './childregister.service';

describe('ChildregisterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ChildregisterService = TestBed.get(ChildregisterService);
    expect(service).toBeTruthy();
  });
});
