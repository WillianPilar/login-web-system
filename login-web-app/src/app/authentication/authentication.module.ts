import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthenticationRoutingModule } from './authentication-routing.module';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [LoginComponent, RegistrationComponent],
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
    LoginComponent,
    RegistrationComponent
  ]
})
export class AuthenticationModule { }
