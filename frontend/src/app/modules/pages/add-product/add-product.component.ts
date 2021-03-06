import {Component, OnInit, TemplateRef} from '@angular/core';
import {Content} from "../../../models/content";
import {Subscription} from "rxjs";
import {ContentService} from "../../../services/content/content.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {ContentTableComponent} from "../../homepage/components/content-table/content-table.component";
import {AuthService} from "../../../services/auth/auth.service";
import {CompanyContentsPageComponent} from "../company-contents-page/company-contents-page.component";

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
              private authService: AuthService,
              private modalService: BsModalService,
              private contentTableComponent: ContentTableComponent,
              private companyComponent: CompanyContentsPageComponent) { }


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
    this.editableContent.userProfile = this.authService.user;
    this.subscriptions.push(this.contentService.saveProduct(this.editableContent).subscribe(() => {
      this.contentTableComponent._updateContent();
      this.companyComponent._updateContent();
      this._closeModal();
    }));
  }
}
