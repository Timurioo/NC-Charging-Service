import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NavbarComponent} from './components/navbar/navbar.component';
import {SearchbarComponent} from './components/searchbar/searchbar.component';
import {AuthModule} from '../auth/auth.module';
import {HomepageModule} from '../homepage/homepage.module';
import {RouterModule} from '@angular/router';
import {NotFoundComponent} from './components/404/not-found.component';
import {UserProfileStorage} from "../../services/user-profile/user-profile.storage";
import {AuthService} from "../../services/auth/auth.service";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";

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
    NgbModule,
    FormsModule
  ],
  exports: [
    SearchbarComponent,
    NavbarComponent,
    NotFoundComponent,
    NgbModule,
    FormsModule
  ],
  providers: [AuthService, UserProfileStorage,]
})
export class LayoutModule {
}
