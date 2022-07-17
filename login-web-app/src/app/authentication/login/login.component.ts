import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public email: string;
  public key: string;

  public errorMessage: string = "Error trying to login";
  public showError: boolean = false;

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  public onSubmit(): void {
    this.authenticationService.login(this.email, this.key).subscribe((response) => {

      this.showError = false;
      this.router.navigate(['/home']);

    }, errorResponse => {

      console.log("Erro: ", errorResponse);
      if (errorResponse.error != undefined) {
        this.errorMessage = errorResponse.error;
      } else {
        this.errorMessage = "Error trying to login";
      }
      this.showError = true;

    });
  }

}
