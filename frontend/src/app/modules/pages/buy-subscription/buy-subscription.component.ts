import {Component, Input, OnInit, Output, TemplateRef} from '@angular/core';
import {Wallet} from "../../../models/wallet";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {WalletService} from "../../../services/wallet/wallet.service";
import {AuthService} from "../../../services/auth/auth.service";
import {UserSubscription} from "../../../models/user-subscription";
import {Content} from "../../../models/content";
import {UserSubscriptionsTableComponent} from "../user-subscriptions-table/user-subscriptions-table.component";
import {SubscriptionService} from "../../../services/subscription/subscription.service";

@Component({
  selector: 'app-buy-subscription',
  templateUrl: './buy-subscription.component.html',
  styleUrls: ['./buy-subscription.component.css']
})
export class BuySubscriptionComponent implements OnInit {

  public editableSubscription: UserSubscription = new UserSubscription();
  public wallets: Wallet[];
  public modalRef: BsModalRef;
  public editMode = false;

  private subscriptions: Subscription[] = [];

  constructor(private walletService: WalletService,
              private modalService: BsModalService,
              private service: SubscriptionService,
              private authService: AuthService) {
  }

  ngOnInit(): void {
    this.loadWallets();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public _addSubscription(): void {
    this.editableSubscription.content = this.service.selectedProduct;
    this.editableSubscription.billingAccount = this.service.selectedWallet;
    this.subscriptions.push(this.service.savSubs(this.editableSubscription).subscribe(() => {
      this._closeModal();
    }));
  }

  private isEnoughFunds(id: string): void {
    this.subscriptions.push(this.walletService.getWalletById(id).subscribe(wallet => {
      if (wallet.funds >= this.service.selectedProduct.cost) return true;
      return false;
    }));
  }

  private loadWallets(): void {
    this.subscriptions.push(this.walletService.getWalletsByUser(this.authService.user.id).subscribe(wallets => {
      this.wallets = wallets as Wallet[];
    }));
  }

}
