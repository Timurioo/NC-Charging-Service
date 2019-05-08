import { Component, OnInit, TemplateRef } from '@angular/core';
import { Content } from '../../../../models/content';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { ContentService } from '../../../../services/content/content.service';
import {Subscription} from "rxjs";
import {AuthService} from "../../../../services/auth/auth.service";
import {SubscriptionService} from "../../../../services/subscription/subscription.service";

@Component({
  selector: 'app-content-table',
  templateUrl: './content-table.component.html',
  styleUrls: ['./content-table.component.css']
})

export class ContentTableComponent implements OnInit {

  public editMode = false;

  public contents: Content[];
  public editableContent: Content = new Content();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private contentService: ContentService,
              private modalService: BsModalService,
              private authService: AuthService,
              private subService: SubscriptionService) { }

  ngOnInit() {
    this.loadProducts();
  }

  public _updateContent(): void {
    this.loadProducts();
  }

  public _deleteContent(id: string): void {
    this.subscriptions.push(this.contentService.deleteProduct(id).subscribe(() => {
      this._updateContent();
    }));
  }

  private refreshContent(): void {
    this.editableContent = new Content();
  }

  private loadProducts(): void {
    this.subscriptions.push(this.contentService.getProducts().subscribe(products => {
      this.contents = products as Content[];
    }));
  }
}
