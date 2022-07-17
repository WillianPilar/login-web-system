import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegistratioRequest } from './registration/registration-request';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(
    private http : HttpClient
  ) { }

  register(registrationRequest : RegistratioRequest){
    return this.http.post<string>("http://localhost:7080/validate-login/api/v1/registration", registrationRequest);
  }

  login(email: string, key: string): Observable<any>{

    let headers = new HttpHeaders()
      .append('email', email)
      .append('key', key);

    return this.http.get<any>('http://localhost:7080/validate-login/api/v1/login', { headers : headers });

  }

}
