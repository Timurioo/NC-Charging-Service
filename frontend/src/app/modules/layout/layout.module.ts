import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { AuthModule } from '../auth/auth.module';
import { HomepageModule } from '../homepage/homepage.module';
import { RouterModule } from '@angular/router';
import { NotFoundComponent } from './components/404/not-found.component';
import { SignInBtnComponent } from '../auth/components/sign-in-btn/sign-in-btn.component';
import { SignUpBtnComponent } from '../auth/components/sign-up-btn/sign-up-btn.component';
import {LoginComponent} from "../auth/components/login/login.component";
import {UserProfileStorage} from "../../services/user-profile/user-profile.storage";
import {AuthService} from "../../services/auth/auth.service";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [
    SearchbarComponent,
    NavbarComponent,
    NotFoundComponent,

  ],
  imports: [
    CommonModule,
    AuthModule,
    HomepageModule,
    RouterModule,
    NgbModule
  ],
  exports: [
    SearchbarComponent,
    NavbarComponent,
    NotFoundComponent,
    NgbModule
  ],
  providers: [AuthService, UserProfileStorage, ]
})
export class LayoutModule { }
