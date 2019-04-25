import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  closeResult: string;

  constructor(private modalService: NgbModal) {}

  open(content) {
    return this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result;
  }

}
