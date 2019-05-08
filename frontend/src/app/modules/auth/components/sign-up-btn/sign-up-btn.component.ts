import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth/auth.service";

@Component({
  selector: 'app-sign-up-btn',
  templateUrl: './sign-up-btn.component.html',
  styleUrls: ['./sign-up-btn.component.css']
})
export class SignUpBtnComponent implements OnInit {

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

}
