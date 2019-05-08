import {Component, OnInit, TemplateRef} from '@angular/core';
import {Content} from "../../../models/content";
import {Subscription} from "rxjs";
import {ContentService} from "../../../services/content/content.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {ContentTableComponent} from "../../homepage/components/content-table/content-table.component";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {
  public editMode = false;

  public contents: Content[];
  public editableContent: Content = new Content();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private contentService: ContentService,
              private modalService: BsModalService,
              private contentTableComponent: ContentTableComponent) { }


  public _closeModal(): void {
    this.modalRef.hide();
  }

  public _openModal(template: TemplateRef<any>, content: Content): void {

    if (content) {
      this.editMode = true;
      this.editableContent = Content.cloneBase(content);
    } else {
      // this.contentTableComponent.refreshContent();
      this.editMode = false;
    }

    this.modalRef = this.modalService.show(template);
  }

  public _addContent(): void {
    this.subscriptions.push(this.contentService.saveProduct(this.editableContent).subscribe(() => {
      this.contentTableComponent._updateContent();
      //this.refreshContent();
      this._closeModal();
    }));
  }
}
