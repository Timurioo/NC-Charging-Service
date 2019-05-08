import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../services/auth/auth.service";
import {WalletService} from "../../../../services/wallet/wallet.service";
import {Wallet} from "../../../../models/wallet";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public isWallet: boolean;
  public wallets: Wallet[];
  public hasAnyWallets: boolean;

  constructor(private authService: AuthService,
              private walletService: WalletService) {
  }

  ngOnInit() {
    this.walletService.getWalletsByUser(this.authService.user.id).subscribe(wallet => {
        this.wallets = wallet as Wallet[];
      }, err => this.hasAnyWallets = false
    );
  }
}
