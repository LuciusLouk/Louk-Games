import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private urlToken:string = "https://www.universal-tutorial.com/api/getaccesstoken";
  private urlCountry:string= "https://www.universal-tutorial.com/api/countries";
  private urlState:string="https://www.universal-tutorial.com/api/states/";
  private urlCity:string="https://www.universal-tutorial.com/api/cities/";
  private httpOptions={
    headers:new HttpHeaders({
      "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJpbXBvcnQuY3VlbnRhLnRyYXNoQGdtYWlsLmNvbSIsImFwaV90b2tlbiI6ImZwdm1PejRaamwyNzYzNGZsZk42QzJ1dXhkX05OelRpTThPb1dtdUNhaE8zZ3BwMFZjRGxFdHRISVhubVBmVFhNelkifSwiZXhwIjoxNzA3MzQyNTI3fQ.dX_qlyOx8dn0ARvLg_X22wXX188IJD_C1mpVUtmWRSY",
      "Accept": "application/json"
    })
  }



  constructor(private _http:HttpClient) { }


  public getToken():Observable<any>{
    let httpOptions={
      headers: new HttpHeaders({
        "Accept": "application/json",
        "api-token": "fpvmOz4Zjl27634flfN6C2uuxd_NNzTiM8OoWmuCahO3gpp0VcDlEttHIXnmPfTXMzY",
        "user-email": "import.cuenta.trash@gmail.com"
      })
    };
    return this._http.get(this.urlToken,this.httpOptions);
  }


  public getCountry():Observable<any>{
    return this._http.get(this.urlCountry,this.httpOptions);
  }

  public getState(country:string):Observable<any>{
    return this._http.get(`${this.urlState}`+country,this.httpOptions);
  }

  public getCity(state:string):Observable<any>{
    return this._http.get(`${this.urlCity}`+state,this.httpOptions);
  }
}
