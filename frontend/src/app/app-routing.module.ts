import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ContentTableComponent } from './content-table/content-table.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LandingComponent } from './landing/landing.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  { path: 'table', component: ContentTableComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'table', component: ContentTableComponent },
  { path: 'landing', component: LandingComponent},
  { path: 'user-profile', component: UserProfileComponent},
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
