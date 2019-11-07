import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AuthToken, UserProfile} from 'src/app/models/user-profile';
import {Router} from "@angular/router";
import {UserProfileStorage} from "../user-profile/user-profile.storage";
import {TokenStorage} from "./token.storage";
import {SubscriptionService} from "../subscription/subscription.service";


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AuthService {

  private loginUrl = '/token/generate-token';
  private getUserUrl = '/token/current';

  public user: UserProfile;
  public token: string;
  public incorrect: boolean;

  public authError: boolean = false;

  constructor(private http: HttpClient,
              private router: Router,
              private userProfileStorage: UserProfileStorage,
              private tokenStorage: TokenStorage,
              private subsService: SubscriptionService) {
    let user = JSON.parse(this.userProfileStorage.getUserProfile());
    let token = this.tokenStorage.getToken();
    if (user && token) {
      this.user = user;
      this.token = token;
    } else {
      this.user = null;
      this.token = "";
    }
  }

  attemptAuth(loginUser: UserProfile): Observable<AuthToken> {
    return this.http.post<AuthToken>(this.loginUrl, loginUser, httpOptions);
  }

  getUser(): Observable<UserProfile> {
    return this.http.get<UserProfile>(this.getUserUrl);
  }

  // public isAuthenticated(): boolean {
  //   const token = sessionStorage.getItem('AuthToken');
  //   return !this.jwtHelper.isTokenExpired(token);
  // }


  public signIn(loginUser: UserProfile): void {
    this.attemptAuth(loginUser).subscribe(data => {
      this.token = data.token;
      this.tokenStorage.saveToken(this.token);
      this.getUser().subscribe(data => {
        this.user = data;
        this.userProfileStorage.saveUserProfile(JSON.stringify(this.user));
        this.router.navigate(['']);
      });
    }, err => {
      this.incorrect = true;
    });
  }

  public logOut(): void {
    sessionStorage.clear();
    this.user = null;
    this.token = "";
    this.subsService.selectedWallet = null;
    this.subsService.selectedProduct = null;
    this.router.navigate(['']);
  }
}
