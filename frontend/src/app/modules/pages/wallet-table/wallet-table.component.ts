import { Component, OnInit } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {AuthService} from "../../../services/auth/auth.service";
import {Wallet} from "../../../models/wallet";
import {WalletService} from "../../../services/wallet/wallet.service";
import {SubscriptionService} from "../../../services/subscription/subscription.service";

@Component({
  selector: 'app-wallet-table',
  templateUrl: './wallet-table.component.html',
  styleUrls: ['./wallet-table.component.css']
})
export class WalletTableComponent implements OnInit {

  public editMode = false;

  public wallets: Wallet[];
  public editableWallet: Wallet = new Wallet();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private walletService: WalletService,
              private subsService: SubscriptionService,
              private modalService: BsModalService,
              private authService: AuthService) { }

  ngOnInit() {
    this.loadWallets();
  }

  public _updateWallet(): void {
    this.loadWallets();
  }

  public _deleteWallet(id: string): void {
    this.subscriptions.push(this.walletService.deleteWallet(id).subscribe(() => {
      this._updateWallet();
    }));
  }

  private refreshWallet(): void {
    this.editableWallet = new Wallet();
  }

  private loadWallets(): void {
    this.subscriptions.push(this.walletService.getWalletsByUser(this.authService.user.id).subscribe(wallets => {
      this.wallets = wallets as Wallet[];
    }));
  }

  private addFunds(funds: string): void {
    this.editableWallet = Wallet.cloneBase(this.subsService.selectedWallet);
    this.editableWallet.funds = (Number(this.subsService.selectedWallet.funds) + Number(funds)).toString();
    this.subscriptions.push(this.walletService.saveWallet(this.editableWallet).subscribe( () => {
    this.refreshWallet();
    this._updateWallet();
    }));
  }
}
