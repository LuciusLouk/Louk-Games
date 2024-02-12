import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';
import {Router } from '@angular/router';
import { Cliente } from 'src/app/models/cliente/cliente';
import { Cuenta } from 'src/app/models/cuenta/cuenta';
import { ClienteService } from 'src/app/services/cliente/cliente.service';
import { CountryService } from 'src/app/services/external/country/country.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
@Component({
  selector: 'app-signup-cliente',
  templateUrl: './signup-cliente.component.html',
  styleUrls: ['./signup-cliente.component.css']
})
export class SignupClienteComponent {
  cliente:Cliente;
  cuenta:Cuenta;
  paises:Array<any>;
  selected: string;
  emailR:string;
  passwordR:string;
  registrar:boolean;
  mensaje:string;
  imagen:string = "assets/icon.svg";


  files: { base: string, safeurl: SafeUrl }[] = [];
  constructor(private domSanitizer: DomSanitizer,
              private usuarioService:UsuarioService,
              private countryService:CountryService,
              private clienteService:ClienteService,
              private router:Router
  ){
    this.selected = "Seleccione una opción";
    this.cliente = new Cliente();
    this.cuenta = new Cuenta();
    this.paises = new Array();
    this.emailR = "";
    this.passwordR="";
    this.registrar = false;
    this.mensaje = "";
  }

  ngOnInit():void{
    this.getCountries();
    
    let safeurl:SafeUrl = this.domSanitizer.bypassSecurityTrustUrl(this.imagen);
    this.files.unshift({ 'base': this.imagen, 'safeurl': safeurl });
  }

  onFileSelected(event: any) {
    const files = event.target.files;
    const file = files[0];
    //inicio lector de archivo
    const reader = new FileReader();
    //declaro el comportamiento del onload cuando el reader carga o lee algo
    reader.onload = () => {
      let base = reader.result as string;
      let safeurl:SafeUrl = this.domSanitizer.bypassSecurityTrustUrl(base);
      console.log("FILES: ",this.files);
      this.files.unshift({ 'base': base, 'safeurl': safeurl });

      //Guarda el base64 en foto de perfil
      this.cuenta.fotoPerfil = this.files[0].base;
      console.log("BASE 64: ",base);
      console.log("SAFEURL: ",this.files[0].safeurl);
      console.log("length", base.length);
      if(this.files.length>0){
        this.files.pop();
      } 
    };
    //hago que el reader lea un archivo
    reader.readAsDataURL(file);

  }
    

  private getCountries(){
    this.countryService.getCountry().subscribe(result=>{
      //console.log(result.country_name);
      Object.assign(this.paises,result);
      console.log(this.paises);
    })
  }

  validarRegistro(){
    this.usuarioService.getUsuarioEmail(this.cliente.email).subscribe(
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
  clienteSubmit(){
    this.cliente.estado = true;
    this.cliente.perfil = "CLIENTE";
    this.cliente.fechaCreacion = new Date();
    this.cuenta.saldo = 0;
    this.cliente.cuenta = this.cuenta;

    console.log(this.cliente);

    this.clienteService.registrarCliente(this.cliente).subscribe(
      result=>{
        console.log(result);
      }
    )
    this.cliente = new Cliente();
    this.router.navigate(['app-miPerfil']);
  }
}
