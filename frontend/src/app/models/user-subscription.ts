import {Wallet} from "./wallet";
import {Content} from "./content";

export class UserSubscription {
  id: string;
  billingAccount: Wallet;
  content: Content;
  isBlocked: string;

  static cloneBase(subs: UserSubscription): UserSubscription {
    const clonedSubscription: UserSubscription = new UserSubscription();
    clonedSubscription.id = subs.id;
    clonedSubscription.billingAccount = subs.billingAccount;
    clonedSubscription.content = subs.content;
    clonedSubscription.isBlocked = subs.isBlocked;
    return clonedSubscription;
  }
}

export class UserSubscriptionStr {

}
