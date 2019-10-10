import { TestBed } from '@angular/core/testing';

import { InventoryitemService } from './inventoryitem.service';

describe('InventoryitemService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InventoryitemService = TestBed.get(InventoryitemService);
    expect(service).toBeTruthy();
  });
});
