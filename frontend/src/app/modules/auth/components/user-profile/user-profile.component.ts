import {Component, Input, OnInit} from '@angular/core';
import {AuthService} from "../../../../services/auth/auth.service";
import {WalletService} from "../../../../services/wallet/wallet.service";
import {Wallet} from "../../../../models/wallet";
import {isNullOrUndefined} from "util";
import {SubscriptionService} from "../../../../services/subscription/subscription.service";


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public isWallet: boolean;
  public wallets: Wallet[];
  public hasAnyWallets: boolean;
  public status: boolean = true;

  constructor(private authService: AuthService,
              private walletService: WalletService,
              private subsService: SubscriptionService) {
  }

  ngOnInit() {
    this.getUserWallets();
  }

  public getUserWallets(): void {
    this.walletService.getWalletsByUser(this.authService.user.id).subscribe(wallet => {
      if (!isNullOrUndefined(wallet)) {
        this.wallets = wallet as Wallet[];
        this.subsService.selectedWallet = this.wallets[0];
        this.hasAnyWallets = true;
      } else this.hasAnyWallets = false;
    });
  }

  public onClick(): void {

  }
}
