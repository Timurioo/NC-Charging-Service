import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../../services/auth/auth.service";
import {UserProfile} from "../../../../models/user-profile";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public currentUser: UserProfile;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

}
