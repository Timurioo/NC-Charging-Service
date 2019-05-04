import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UserProfileComponent} from './components/user-profile/user-profile.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {RouterModule} from '@angular/router';
import {FormsModule} from "@angular/forms";
import {UserProfileService} from "../../services/user-profile/user-profile.service";
import {AuthService} from "../../services/auth/auth.service";
import {TokenStorage} from "../../services/auth/token.storage";
import {UserProfileStorage} from "../../services/user-profile/user-profile.storage";
import {PagesModule} from "../pages/pages.module";
import {SignInBtnComponent} from "./components/sign-in-btn/sign-in-btn.component";
import {SignUpBtnComponent} from "./components/sign-up-btn/sign-up-btn.component";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {AddProductComponent} from "../pages/add-product/add-product.component";
import {ContentTableComponent} from "../homepage/components/content-table/content-table.component";
import {AddWalletComponent} from "../pages/add-wallet/add-wallet.component";
import {WalletTableComponent} from "../pages/wallet-table/wallet-table.component";
import {HomepageModule} from "../homepage/homepage.module";


@NgModule({
  declarations: [LoginComponent,
    RegisterComponent, UserProfileComponent, SignInBtnComponent,
    SignUpBtnComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    PagesModule,
    HomepageModule,
    NgbModule
  ],
  exports: [
    UserProfileComponent,
    LoginComponent, RegisterComponent, SignInBtnComponent,
    SignUpBtnComponent,
    NgbModule
  ],
  providers: [UserProfileService, AuthService, TokenStorage, UserProfileStorage, AddProductComponent, ContentTableComponent, AddWalletComponent, WalletTableComponent]
})
export class AuthModule {
}
