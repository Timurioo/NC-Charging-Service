import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { NgHttpLoaderModule } from 'ng-http-loader';
import { LayoutModule } from './modules/layout/layout.module';
import { AuthModule } from './modules/auth/auth.module';
import { AppComponent } from './app.component';
import { HomepageModule } from './modules/homepage/homepage.module';
import { RouterModule, Routes } from '@angular/router';
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule} from "@angular/forms";
import {PagesModule} from "./modules/pages/pages.module";

import { ContentTableComponent } from './modules/homepage/components/content-table/content-table.component';
import { LandingComponent } from './modules/homepage/components/landing/landing.component';
import { UserProfileComponent } from './modules/auth/components/user-profile/user-profile.component';
import { NotFoundComponent } from './modules/layout/components/404/not-found.component';
import { RegisterComponent } from "./modules/auth/components/register/register.component";
import { LoginComponent } from "./modules/auth/components/login/login.component";
import {Interceptor} from "./app.interceptor";


const appRoutes: Routes = [
  {path: "", component: LandingComponent},
  { path: 'table', component: ContentTableComponent },
  { path: 'landing', component: LandingComponent},
  { path: 'user-profile', component: UserProfileComponent},
  { path: 'sign-up', component: RegisterComponent},
  { path: 'sign-in', component: LoginComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    NgHttpLoaderModule.forRoot(),
    LayoutModule,
    AuthModule,
    HomepageModule,
    ModalModule.forRoot(),
    FormsModule,
    PagesModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: Interceptor,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
