import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import { BuscadorIdeaRetoService } from './buscador-idea-reto.service';

@Component({
  selector: 'app-buscador-idea-reto',
  templateUrl: './buscador-idea-reto.component.html',
  styleUrls: ['./buscador-idea-reto.component.css']
})
export class BuscadorIdeaRetoComponent implements OnInit {


  ideas: Observable<any>;
  retos: Observable<any>;
  users: Observable<any>;
  constructor(private appService: BuscadorIdeaRetoService) { }

  ngOnInit() {
    this.getIdeas();
    this.getRetos();
    this.getUsers();  }
  getIdeas(): void {
    this.appService.getIdeasList().subscribe(
      data => this.ideas = data);
  }

  getRetos(): void {
    this.appService.getRetosList().subscribe(
      data => this.retos = data);
  }

  getUsers(): void {
    this.appService.getUsuariosList().subscribe(
      data => this.users = data);
  }

}
