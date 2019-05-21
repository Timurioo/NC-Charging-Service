import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AddProductComponent} from './add-product/add-product.component';
import {FormsModule} from "@angular/forms";
import {AddWalletComponent} from "./add-wallet/add-wallet.component";
import {WalletTableComponent} from './wallet-table/wallet-table.component';
import {UserSubscriptionsTableComponent} from './user-subscriptions-table/user-subscriptions-table.component';
import {BuySubscriptionComponent} from './buy-subscription/buy-subscription.component';
import {UserTableComponent} from './user-table/user-table.component';
import {RouterModule} from "@angular/router";
import {UserTableBtnComponent} from './user-table-btn/user-table-btn.component';
import { ProductPageComponent } from './product-page/product-page.component';
import {SubscriptionService} from "../../services/subscription/subscription.service";
import {AuthService} from "../../services/auth/auth.service";
import { ProductPageBtnComponent } from './product-page-btn/product-page-btn.component';
import { SearchEngineComponent } from './search-engine/search-engine.component';
import {LayoutModule} from "../layout/layout.module";

@NgModule({
  declarations: [AddProductComponent, AddWalletComponent, WalletTableComponent, UserSubscriptionsTableComponent, BuySubscriptionComponent, UserTableComponent, UserTableBtnComponent, ProductPageComponent, ProductPageBtnComponent, SearchEngineComponent],
  imports: [
    NgbModule,
    CommonModule,
    FormsModule,
    RouterModule
  ],
  exports: [
    AddProductComponent,
    AddWalletComponent,
    WalletTableComponent,
    UserSubscriptionsTableComponent,
    BuySubscriptionComponent,
    UserTableComponent,
    UserTableBtnComponent,
    ProductPageComponent,
    ProductPageBtnComponent,
    SearchEngineComponent
  ],
  providers: [BuySubscriptionComponent, UserTableComponent, SubscriptionService, AuthService]
})
export class PagesModule {
}
