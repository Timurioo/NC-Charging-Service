import { Component, OnInit } from '@angular/core';
import {SubscriptionService} from "../../../services/subscription/subscription.service";

@Component({
  selector: 'app-product-page-btn',
  templateUrl: './product-page-btn.component.html',
  styleUrls: ['./product-page-btn.component.css']
})
export class ProductPageBtnComponent implements OnInit {

  constructor(private subService: SubscriptionService) { }

  ngOnInit() {
  }

}
