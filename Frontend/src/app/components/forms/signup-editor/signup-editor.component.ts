import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Editor } from 'src/app/models/editor/editor';
import { EditorService } from 'src/app/services/editor/editor.service';
import { CountryService } from 'src/app/services/external/country/country.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
@Component({
  selector: 'app-signup-editor',
  templateUrl: './signup-editor.component.html',
  styleUrls: ['./signup-editor.component.css']
})
export class SignupEditorComponent {
  editores:Array<Editor>;
  editor:Editor;
  paises:Array<any>;
  provincias:Array<any>;
  ciudades:Array<any>;
  emailR:string;
  passwordR:string;
  registrar:boolean;
  mensaje:string;
  constructor(
              private usuarioService:UsuarioService,
              private editorService:EditorService,
              private countryService:CountryService,
              private router:Router
  ){
    this.editor = new Editor();
    this.editores = new Array();
    this.paises = new Array();
    this.provincias = new Array();
    this.ciudades = new Array();
    this.emailR="";
    this.passwordR="";
    this.registrar = false;
    this.mensaje = "";
  }

  ngOnInit():void{
    this.getCountries();
  }
  private getToken(){
    this.countryService.getToken().subscribe(
      result=>{
        console.log(result);
      }
    )
  }

  private getCountries(){
    this.countryService.getCountry().subscribe(result=>{
      Object.assign(this.paises,result);
    })
  }
  cargarProvincias(){
    this.provincias = new Array();
    this.countryService.getState(this.editor.pais).subscribe(
      result=>{
        console.log(result);
        Object.assign(this.provincias,result);
        console.log(this.provincias);
      }
    )
  }
  cargarCiudades(){
    this.ciudades = new Array();
    this.countryService.getCity(this.editor.estadoProvincia).subscribe(
      result=>{
        console.log(result);
        Object.assign(this.ciudades,result)
      }
    )
  }

  validarRegistro(){
    this.usuarioService.getUsuarioEmail(this.editor.email).subscribe(
      result=>{
        console.log(result);
        if(result==null){
          console.log("crear usuario");
          this.registrar = true;
          this.mensaje = "Confirmar registro";
        }
        else{
          console.log("usuario existente");
          this.registrar = false;
          this.mensaje = "El correo electrónico especificado se encuentra ya ocupado";
        }
      }
    )
  }

  editorSubmit(){
    console.log("registro realizado");
    this.editor.estado=true;
    this.editor.fechaCreacion = new Date();
    this.editor.perfil = "EDITOR";
    this.editorService.registrarEditor(this.editor).subscribe(
      result=>{
        console.log(result);
    })
    this.editor = new Editor();
    this.router.navigate(['app-miPerfil'])
  }

  
  
}
