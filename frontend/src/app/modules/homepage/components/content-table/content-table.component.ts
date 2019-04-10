import { Component, OnInit } from '@angular/core';
import { Content } from './models/content';
import { ContentService } from '../../../../services/content.service';
import {Subscription} from "rxjs";

@Component({
  selector: 'app-content-table',
  templateUrl: './content-table.component.html',
  styleUrls: ['./content-table.component.css']
})

export class ContentTableComponent implements OnInit {

  public editMode = false;

  public contents: Content[];
  public editableContent: Content = new Content();

  private subscriptions: Subscription[] = [];

  constructor(private contentService: ContentService) { }

  ngOnInit() {
    this.loadProducts();
  }

  private loadProducts(): void {
    // Get data from BillingAccountService
    this.subscriptions.push(this.contentService.getProducts().subscribe(products => {
      // Parse json response into local array
      this.contents = products as Content[];
      // Check data in console
      console.log(this.contents);
    }));
  }
}
