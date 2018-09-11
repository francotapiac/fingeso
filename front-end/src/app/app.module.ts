import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PerfilComponent } from './perfil/perfil.component';
import { AportesComponent } from './aportes/aportes.component';
import { NoticiaComponent } from './noticia/noticia.component';
import { ProximoEventoComponent } from './proximo-evento/proximo-evento.component';
import { BuscadorIdeaRetoComponent } from './buscador-idea-reto/buscador-idea-reto.component';
import { FormularioIdeaComponent } from './formulario-idea/formulario-idea.component';
import { FormularioRetoComponent } from './formulario-reto/formulario-reto.component';
import { BarraNavegacionComponent } from './barra-navegacion/barra-navegacion.component';

import { RegistroComponent } from './registro/registro.component';
const appRoutes: Routes =[
  {path: 'home', component: HomeComponent},
  {path: 'idea', component: FormularioIdeaComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PerfilComponent,
    AportesComponent,
    NoticiaComponent,
    ProximoEventoComponent,
    BuscadorIdeaRetoComponent,
    FormularioIdeaComponent,
    FormularioRetoComponent,
    BarraNavegacionComponent,
    RegistroComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {

}
