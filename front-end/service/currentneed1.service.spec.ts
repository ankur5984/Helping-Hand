import { TestBed } from '@angular/core/testing';

import { Currentneed1Service } from './currentneed1.service';

describe('Currentneed1Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Currentneed1Service = TestBed.get(Currentneed1Service);
    expect(service).toBeTruthy();
  });
});
