import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgHttpLoaderModule } from 'ng-http-loader';
import { LayoutModule } from './modules/layout/layout.module';
import { AuthModule } from './modules/auth/auth.module';
import { AppComponent } from './app.component';
import { HomepageModule } from './modules/homepage/homepage.module';
import { RouterModule, Routes } from '@angular/router';

import { ContentTableComponent } from './modules/homepage/components/content-table/content-table.component';
import { LandingComponent } from './modules/homepage/components/landing/landing.component';
import { UserProfileComponent } from './modules/auth/components/user-profile/user-profile.component';
import { NotFoundComponent } from './modules/layout/components/404/not-found.component';

const appRoutes: Routes = [
  {path: "", component: LandingComponent},
  { path: 'table', component: ContentTableComponent },
  { path: 'landing', component: LandingComponent},
  { path: 'user-profile', component: UserProfileComponent},
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
    HomepageModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
