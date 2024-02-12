import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './components/layout/header/header.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { MiPerfilComponent } from './components/pages/mi-perfil/mi-perfil.component';
import { HomeComponent } from './components/pages/home/home.component';
import { TiendaComponent } from './components/pages/tienda/tienda.component';
import { ModalSignupComponent } from './components/componentes/modal-signup/modal-signup.component';
import { ListClienteComponent } from './components/componentes/list-cliente/list-cliente.component';
import { ListEditorComponent } from './components/componentes/list-editor/list-editor.component';
import { SignupClienteComponent } from './components/forms/signup-cliente/signup-cliente.component';
import { SignupEditorComponent } from './components/forms/signup-editor/signup-editor.component';
import { UsuariosComponent } from './components/pages/usuarios/usuarios.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    MiPerfilComponent,
    HomeComponent,
    TiendaComponent,
    ModalSignupComponent,
    ListClienteComponent,
    ListEditorComponent,
    SignupClienteComponent,
    SignupEditorComponent,
    UsuariosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
