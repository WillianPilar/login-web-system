import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { Name, RegistratioRequest } from './registration-request';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  public registrationRequest : RegistratioRequest = new RegistratioRequest();
  public name : Name = new Name();

  public errorMessage : string = "Error trying to register";
  public showError : boolean = false;
  public showSuccess : boolean = false;

  constructor(
    private authenticationService : AuthenticationService,
    private router : Router,
  ) { }

  ngOnInit(): void {
  }

  public onSubmit(): void{
    
    this.registrationRequest.name = this.name;
    this.authenticationService.register(this.registrationRequest).subscribe( response => {
      this.showSuccess = true;
      this.showError = false;
      console.log(response);
    }, errorResponse => {

      if (errorResponse.error != undefined) {
        this.errorMessage = errorResponse.error;
      }else{
        this.errorMessage = "Error trying to register";
      }
      this.showError = true;
      this.showSuccess = false;
    });
    
  }

  public newRegister(): void{

    this.showSuccess = false;
    this.registrationRequest = new RegistratioRequest();
    this.name = new Name();

  }

  public goToLogin(): void{
    this.router.navigate(['/login']);
  }


}
