import { Injectable } from '@angular/core';

const USER_KEY = 'userProfile';

@Injectable()
export class UserProfileStorage {

  constructor() { }

  public saveUserProfile(user: string) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY,  user);
  }

  public getUserProfile(): string {
    return sessionStorage.getItem(USER_KEY);
  }
}
