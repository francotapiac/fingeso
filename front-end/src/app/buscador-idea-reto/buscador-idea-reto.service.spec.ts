import { TestBed, inject } from '@angular/core/testing';

import { BuscadorIdeaRetoService } from './buscador-idea-reto.service';

describe('BuscadorIdeaRetoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BuscadorIdeaRetoService]
    });
  });

  it('should be created', inject([BuscadorIdeaRetoService], (service: BuscadorIdeaRetoService) => {
    expect(service).toBeTruthy();
  }));
});
