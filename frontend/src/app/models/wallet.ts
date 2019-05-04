import {UserProfile} from "./user-profile";

export class Wallet {
  id: string;
  walletId: string;
  funds: string;
  userProfile: UserProfile;
  isActive: string;

  static cloneBase(wallet: Wallet): Wallet {
    const clonedWallet: Wallet = new Wallet();
    clonedWallet.id = wallet.id;
    clonedWallet.walletId = wallet.walletId;
    clonedWallet.funds = wallet.funds;
    clonedWallet.isActive = wallet.isActive;
    clonedWallet.userProfile = wallet.userProfile;
    return clonedWallet;
  }
}
