import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MiPerfilComponent } from './components/pages/mi-perfil/mi-perfil.component';
import { SignupEditorComponent } from './components/forms/signup-editor/signup-editor.component';
import { SignupClienteComponent } from './components/forms/signup-cliente/signup-cliente.component';

const routes: Routes = [
  {path:"app-editor-signup",component:SignupEditorComponent},
  {path:"app-cliente-signup",component:SignupClienteComponent},
  {path:"app-login",component:LoginComponent},
  {path:"app-miPerfil",component:MiPerfilComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
