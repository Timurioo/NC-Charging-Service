import {Component, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {Wallet} from "../../../models/wallet";
import {WalletService} from "../../../services/wallet/wallet.service";
import {WalletTableComponent} from "../wallet-table/wallet-table.component";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-add-wallet',
  templateUrl: './add-wallet.component.html',
  styleUrls: ['./add-wallet.component.css']
})
export class AddWalletComponent {

  closeResult: string;
  public editableWallet: Wallet = new Wallet();
  public modalRef: BsModalRef;
  public editMode = false;

  private subscriptions: Subscription[] = [];

  constructor(private walletService: WalletService,
              private modalService: BsModalService,
              private walletTableComponent: WalletTableComponent,
              private authService: AuthService) { }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, wallet: Wallet): void {

    if (wallet) {
      this.editMode = true;
      this.editableWallet = Wallet.cloneBase(wallet);
    } else {
      // this.contentTableComponent.refreshContent();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  public _addWallet(): void {
    this.editableWallet.userProfile = this.authService.user;
    this.editableWallet.isActive = '1';
    this.subscriptions.push(this.walletService.saveWallet(this.editableWallet).subscribe(() => {
      this.walletTableComponent._updateWallet();
      this._closeModal();
    }));
  }

}

