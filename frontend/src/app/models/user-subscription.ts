import {Wallet} from "./wallet";
import {Content} from "./content";

export class UserSubscription {
  id: string;
  billingAccount: Wallet;
  content: Content;

  static cloneBase(subs: UserSubscription): UserSubscription {
    const clonedSubscription: UserSubscription = new UserSubscription();
    clonedSubscription.id = subs.id;
    clonedSubscription.billingAccount = subs.billingAccount;
    clonedSubscription.content = subs.content;
    return clonedSubscription;
  }
}

export class UserSubscriptionStr {

}
