import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddProductComponent } from './add-product/add-product.component';
import {FormsModule} from "@angular/forms";
import {AddWalletComponent} from "./add-wallet/add-wallet.component";
import { WalletTableComponent } from './wallet-table/wallet-table.component';
import { UserSubscriptionsTableComponent } from './user-subscriptions-table/user-subscriptions-table.component';
import { BuySubscriptionComponent } from './buy-subscription/buy-subscription.component';

@NgModule({
  declarations: [AddProductComponent, AddWalletComponent, WalletTableComponent, UserSubscriptionsTableComponent, BuySubscriptionComponent],
  imports: [
    NgbModule,
    CommonModule,
    FormsModule,
  ],
  exports: [
    AddProductComponent,
    AddWalletComponent,
    WalletTableComponent,
    UserSubscriptionsTableComponent,
    BuySubscriptionComponent
  ],
  providers: [BuySubscriptionComponent]
})
export class PagesModule { }
