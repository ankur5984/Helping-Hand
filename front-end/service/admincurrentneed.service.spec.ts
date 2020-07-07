import { TestBed } from '@angular/core/testing';

import { AdmincurrentneedService } from './admincurrentneed.service';

describe('AdmincurrentneedService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdmincurrentneedService = TestBed.get(AdmincurrentneedService);
    expect(service).toBeTruthy();
  });
});
