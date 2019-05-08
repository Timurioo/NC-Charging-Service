import {Component, OnInit} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {UserSubscription} from "../../../models/user-subscription";
import {AuthService} from "../../../services/auth/auth.service";
import {SubscriptionService} from "../../../services/subscription/subscription.service";
import {ContentService} from "../../../services/content/content.service";
import {BuySubscriptionComponent} from "../buy-subscription/buy-subscription.component";

@Component({
  selector: 'app-user-subscriptions-table',
  templateUrl: './user-subscriptions-table.component.html',
  styleUrls: ['./user-subscriptions-table.component.css']
})
export class UserSubscriptionsTableComponent implements OnInit {

  public editMode = false;

  public userSubs: UserSubscription[];
  public editableSubscription: UserSubscription = new UserSubscription();
  public hasAnySubs: boolean;

  private subscriptions: Subscription[] = [];

  constructor(private subscriptionService: SubscriptionService,
              private contentService: ContentService,
              private modalService: BsModalService,
              private authService: AuthService,
              private buySub: BuySubscriptionComponent) {
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
    this.subscriptions.push(this.subscriptionService.getSubsByWallet(this.subscriptionService.selectedWallet.id).subscribe(subscriptions => {
        this.userSubs = subscriptions as UserSubscription[];
      }, err => this.hasAnySubs = false
    ));
  }
}
