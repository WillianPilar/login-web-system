import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
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

}
