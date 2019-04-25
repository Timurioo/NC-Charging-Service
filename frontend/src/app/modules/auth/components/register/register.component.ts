import { Component } from '@angular/core';
import { Subscription } from "rxjs";
import { UserProfileService } from "../../../../services/user-profile/user-profile.service";
import { UserProfile } from "src/app/models/user-profile";
import {Role} from "../../../../models/role";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  closeResult: string;

  constructor(private userProfileService: UserProfileService) { }

  
  public editMode = false;

  public users: UserProfile[];
  public editableUserProfile: UserProfile = new UserProfile();
  public existingEmail: boolean;

  private subscriptions: Subscription[] = [];

  ngOnInit() {
  }


  public _registerUser(): void {
    this.editableUserProfile.role = new Role();
    this.subscriptions.push(this.userProfileService.saveUserProfile(this.editableUserProfile).subscribe(() => {
      //this._updateUsers();
      this.refreshUsers();
    }));
  }

  public _updateUsers(): void {
    this.loadUsers();
  }

  public _deleteUser(id: string): void {
    this.subscriptions.push(this.userProfileService.deleteUserProfile(id).subscribe(() => {
      this._updateUsers();
    }));
  }

  private refreshUsers(): void {
    this.editableUserProfile = new UserProfile();
    this.editableUserProfile.role = new Role();
  }

  private loadUsers(): void {
    this.subscriptions.push(this.userProfileService.getUserProfiles().subscribe(users => {
      this.users = users as UserProfile[];
    }));
  }

  private isExists(email: string): void {
    this.subscriptions.push(this.userProfileService.getUserProfileByEmail(email).subscribe(  isExist => {
      this.existingEmail = true;
      if (!isExist) this.existingEmail = false;
    }));
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}
