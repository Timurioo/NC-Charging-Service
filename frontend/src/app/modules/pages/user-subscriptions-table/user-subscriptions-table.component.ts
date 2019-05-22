import {Component, OnInit} from '@angular/core';
import {BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {UserSubscription} from "../../../models/user-subscription";
import {AuthService} from "../../../services/auth/auth.service";
import {SubscriptionService} from "../../../services/subscription/subscription.service";
import {ContentService} from "../../../services/content/content.service";
import {isNullOrUndefined} from 'util';
import {Wallet} from "../../../models/wallet";
import {WalletService} from "../../../services/wallet/wallet.service";

@Component({
  selector: 'app-user-subscriptions-table',
  templateUrl: './user-subscriptions-table.component.html',
  styleUrls: ['./user-subscriptions-table.component.css']
})
export class UserSubscriptionsTableComponent implements OnInit {

  public editMode = false;

  public editableSubscription: UserSubscription = new UserSubscription();
  public hasAnySubs: boolean;
  public editableWallet: Wallet = new Wallet();

  private subscriptions: Subscription[] = [];

  constructor(private subscriptionService: SubscriptionService,
              private contentService: ContentService,
              private modalService: BsModalService,
              private authService: AuthService,
              private walletService: WalletService) {
  }

  ngOnInit() {
    this.loadSubs();
  }

  public _updateSubs(): void {
    this.loadSubs();
  }

  public _deleteSubs(id: string): void {
    this.subscriptions.push(this.subscriptionService.deleteSubs(id).subscribe(() => {
      this._updateSubs();
    }));
  }

  private refreshSubs(): void {
    this.editableSubscription = new UserSubscription();
  }

  private loadSubs(): void {
    this.subscriptions.push(this.walletService.getWalletsByUser(this.authService.user.id).subscribe(wallets => {
      if (!isNullOrUndefined(wallets)) this.subscriptionService.selectedWallet = wallets[0];
      if (!isNullOrUndefined(this.subscriptionService.selectedWallet)) {
        this.subscriptions.push(this.subscriptionService.getSubsByWallet(this.subscriptionService.selectedWallet.id).subscribe(subscriptions => {
            this.subscriptionService.userSubs = subscriptions as UserSubscription[];
            this.hasAnySubs = true;
          }, error => this.hasAnySubs = false
        ));
      }
    }));
  }

  private

  loadWallets(): void {
    this.subscriptions.push(this.walletService.getWalletsByUser(this.authService.user.id).subscribe(wallets => {
      if (!isNullOrUndefined(wallets)) this.subscriptionService.selectedWallet = wallets[0];
    }));
  }

  private addFunds(funds: string):
    void {
    this.editableWallet = Wallet.cloneBase(this.subscriptionService.selectedWallet);
    this.editableWallet.funds = (Number(this.subscriptionService.selectedWallet.funds) + Number(funds)).toString();
    this.subscriptions.push(this.walletService.saveWallet(this.editableWallet).subscribe(() => {
      this._updateSubs();
    }));
  }
}
