import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileLogoComponent } from './components/user-profile-logo/user-profile-logo.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { WalletPageComponent } from './components/wallet-page/wallet-page.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [UserProfileLogoComponent,
    WalletPageComponent, LoginComponent,
    RegisterComponent, UserProfileComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    UserProfileLogoComponent, UserProfileComponent, WalletPageComponent,
    LoginComponent, RegisterComponent
  ]
})
export class AuthModule { }
