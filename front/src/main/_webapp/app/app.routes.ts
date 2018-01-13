
import { RouterModule, Routes } from '@angular/router';
import { ListagemComponent } from './listagem/listagem.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { FamiliaComponent } from "./familia/familia.component";


const appRoutes: Routes  = [
  { path: '', component: ListagemComponent },
  { path: 'cadastro', component: CadastroComponent },
  { path: 'familia', component: FamiliaComponent },
  { path: '**', component: ListagemComponent }
];

export const routing = RouterModule.forRoot(appRoutes);