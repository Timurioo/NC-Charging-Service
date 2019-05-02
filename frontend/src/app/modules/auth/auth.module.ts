import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileLogoComponent } from './components/user-profile-logo/user-profile-logo.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { RouterModule } from '@angular/router';
import {FormsModule} from "@angular/forms";
import {UserProfileService} from "../../services/user-profile/user-profile.service";
import {AuthService} from "../../services/auth/auth.service";
import {TokenStorage} from "../../services/auth/token.storage";
import {UserProfileStorage} from "../../services/user-profile/user-profile.storage";
import {PagesModule} from "../pages/pages.module";
import {SignInBtnComponent} from "./components/sign-in-btn/sign-in-btn.component";
import {SignUpBtnComponent} from "./components/sign-up-btn/sign-up-btn.component";


@NgModule({
  declarations: [UserProfileLogoComponent, LoginComponent,
    RegisterComponent, UserProfileComponent, SignInBtnComponent,
    SignUpBtnComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    PagesModule
  ],
  exports: [
    UserProfileLogoComponent, UserProfileComponent,
    LoginComponent, RegisterComponent, SignInBtnComponent,
    SignUpBtnComponent
    ],
  providers: [UserProfileService, AuthService, TokenStorage, UserProfileStorage]
})
export class AuthModule { }
