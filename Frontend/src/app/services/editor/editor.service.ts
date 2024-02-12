import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Editor } from 'src/app/models/editor/editor';

@Injectable({
  providedIn: 'root'
})
export class EditorService {

  private urlBase ="http://localhost:8080/usuario/editores"

  constructor(private httpCliente:HttpClient) {
   }

   getEditores():Observable<Editor[]>{
    return this.httpCliente.get<Editor[]>(`${this.urlBase}`);
   }

   registrarEditor(editor:Editor):Observable<any>{
    return this.httpCliente.post(this.urlBase,editor);
   }
}
