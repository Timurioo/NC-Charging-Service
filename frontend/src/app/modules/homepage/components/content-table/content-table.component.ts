import { Component, OnInit, TemplateRef } from '@angular/core';
import { Content } from '../../../../models/content';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import { ContentService } from '../../../../services/content/content.service';
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
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private contentService: ContentService,
              private modalService: BsModalService) { }

  ngOnInit() {
    this.loadProducts();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, content: Content): void {

    if (content) {
      this.editMode = true;
      this.editableContent = Content.cloneBase(content);
    } else {
      this.refreshContent();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  public _addContent(): void {
    this.subscriptions.push(this.contentService.saveProduct(this.editableContent).subscribe(() => {
      this._updateContent();
      this.refreshContent();
      this._closeModal();
    }));
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
