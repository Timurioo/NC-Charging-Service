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
import {AddProductComponent} from "../pages/add-product/add-product.component";
import {BuySubscriptionComponent} from "../pages/buy-subscription/buy-subscription.component";
import {SubscriptionService} from "../../services/subscription/subscription.service";
import {RouterModule} from "@angular/router";
import {ProductPageBtnComponent} from "../pages/product-page-btn/product-page-btn.component";

@NgModule({
  declarations: [CarouselComponent, ContentTableComponent, LandingComponent],
  imports: [
    NgbModule,
    CommonModule,
    FormsModule,
    PagesModule,
    NgbModule,
    RouterModule
  ],
  exports: [
    CarouselComponent, ContentTableComponent, LandingComponent, NgbModule
  ],
  providers: [ContentService, AuthService, AddProductComponent, SubscriptionService, ProductPageBtnComponent]
})
export class HomepageModule { }
