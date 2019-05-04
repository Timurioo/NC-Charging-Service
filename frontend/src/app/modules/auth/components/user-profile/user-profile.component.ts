import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth/auth.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public isWallet: boolean;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

}
