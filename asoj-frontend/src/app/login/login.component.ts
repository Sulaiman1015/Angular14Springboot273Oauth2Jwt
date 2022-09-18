import { Component, OnInit } from '@angular/core';

declare var loginjs: any

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: any;


  constructor() {

   }

  ngOnInit(): void {
     new loginjs();
  }

  loginSubmit() {

  }
}
