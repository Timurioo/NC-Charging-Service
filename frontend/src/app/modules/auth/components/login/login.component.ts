import {Component, NgZone, OnInit} from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {AuthService} from "../../../../services/auth/auth.service";
import {TokenStorage} from "../../../../services/auth/token.storage";
import {Router} from "@angular/router";
import {UserProfile} from "../../../../models/user-profile";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UserProfileStorage} from "../../../../services/user-profile/user-profile.storage";


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
              private token: TokenStorage,
              private userProfileStorage: UserProfileStorage) {
    this.isLogged = false;
  }


  ngOnInit() {
    this.formGroup = new FormGroup({
      Username: new FormControl('', [Validators.required]),
      Password: new FormControl('', [Validators.required])
    });
  }

  public loginUser: UserProfile = new UserProfile();
  public incorrect: boolean = false;
  public isLogged: boolean;
  formGroup: FormGroup;
  public user: UserProfile;

  onSubmit(): void {
    this.authService.signIn(this.loginUser);
  }

  /*public _login(): void {
    this.authService.attemptAuth(this.loginUser.email, this.loginUser.password).subscribe(
      data => {
        this.token.saveToken(data.token);
        this.authService.getUser(data.token).subscribe( user =>
        this.userProfileStorage.saveUserProfile(JSON.stringify(user)));
        this.isLogged = true;
        console.log(this.isLogged);
        this.router.navigate(['']);
      }, () => {
        this.incorrect = true;
      }
    );
  }*/


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
