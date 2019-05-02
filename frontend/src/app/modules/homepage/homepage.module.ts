import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ContentTableComponent } from './components/content-table/content-table.component';
import { LandingComponent } from './components/landing/landing.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ContentService } from 'src/app/services/content/content.service';
import {FormsModule} from '@angular/forms';
import {PagesModule} from "../pages/pages.module";
import {AuthService} from "../../services/auth/auth.service";

@NgModule({
  declarations: [CarouselComponent, ContentTableComponent, LandingComponent],
  imports: [
    NgbModule,
    CommonModule,
    FormsModule,
    PagesModule
  ],
  exports: [
    CarouselComponent, ContentTableComponent, LandingComponent
  ],
  providers: [ContentService, AuthService]
})
export class HomepageModule { }
