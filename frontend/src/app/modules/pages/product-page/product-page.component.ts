import { Component, OnInit } from '@angular/core';
import {SubscriptionService} from "../../../services/subscription/subscription.service";
import {Subscription} from "rxjs";
import {AuthService} from "../../../services/auth/auth.service";

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent implements OnInit {

  constructor(private subsService: SubscriptionService,
              private authService: AuthService) { }

  private subscriptions: Subscription[] = [];
  private hasSub: boolean;


  ngOnInit() {
  }



}
