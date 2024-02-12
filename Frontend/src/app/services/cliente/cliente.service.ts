import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from 'src/app/models/cliente/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private urlBase ="http://localhost:8080/usuario/clientes"
  constructor(private _http:HttpClient) { }

  registrarCliente(cliente:Cliente):Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        "Content-Type":"application/json"
      })
    }
    var body = JSON.stringify(cliente);
    return this._http.post(this.urlBase,cliente,httpOptions);
  }

  
}
