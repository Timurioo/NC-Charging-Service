import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ContentTableComponent } from './components/content-table/content-table.component';
import { LandingComponent } from './components/landing/landing.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [CarouselComponent, ContentTableComponent, LandingComponent],
  imports: [
    NgbModule,
    CommonModule,
  ],
  exports: [
    CarouselComponent, ContentTableComponent, LandingComponent
  ]
})
export class HomepageModule { }
