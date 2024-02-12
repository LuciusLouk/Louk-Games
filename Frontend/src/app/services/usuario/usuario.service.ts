import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from 'src/app/models/usuario/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlBase ="http://localhost:8080/usuario/usuarios/"
  constructor(private _http:HttpClient) { }


  public getUsuarioEmail(email:string):Observable<any>{
    return this._http.get(`${this.urlBase}`+email);
  }

}
