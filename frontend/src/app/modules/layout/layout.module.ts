import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SearchbarComponent } from './components/searchbar/searchbar.component';
import { AuthModule } from '../auth/auth.module';
import { HomepageModule } from '../homepage/homepage.module';
import { RouterModule } from '@angular/router';
import { NotFoundComponent } from './components/404/not-found.component';
import { SignInBtnComponent } from './components/navbar/sign-in-btn/sign-in-btn.component';
import { SignUpBtnComponent } from './components/navbar/sign-up-btn/sign-up-btn.component';

@NgModule({
  declarations: [
    SearchbarComponent,
    NavbarComponent,
    NotFoundComponent,
    SignInBtnComponent,
    SignUpBtnComponent
  ],
  imports: [
    CommonModule,
    AuthModule,
    HomepageModule,
    RouterModule
  ],
  exports: [
    SearchbarComponent,
    NavbarComponent,
    NotFoundComponent
  ]
})
export class LayoutModule { }
