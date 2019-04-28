import {Component, NgZone, OnInit} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {AuthService} from "../../../../services/auth/auth.service";
import {TokenStorage} from "../../../../services/auth/token.storage";
import {Router} from "@angular/router";
import {UserProfile} from "../../../../models/user-profile";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  closeResult: string;

  constructor(private modalService: NgbModal,
              private zone: NgZone,
              private router: Router,
              private authService: AuthService,
              private token: TokenStorage) {
  }

  public loginUser: UserProfile = new UserProfile();
  public incorrect: boolean = false;


  public _login(): void {
    this.authService.attemptAuth(this.loginUser.email, this.loginUser.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        this.reloadPage();
        this.router.navigate(['user-profile']);
      }, () => {
        this.incorrect = true;
      }
    );
  }

  open(content) {
    return this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result;
  }

  reloadPage() {
    this.zone.runOutsideAngular(() => {
      location.reload();
    });
  }

  closeAlert(): void {
    this.incorrect = false;
  }

}
