import {Component, OnInit} from '@angular/core';
import {BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {SubscriptionService} from "../../../services/subscription/subscription.service";
import {AuthService} from "../../../services/auth/auth.service";
import {UserProfileService} from "../../../services/user-profile/user-profile.service";
import {UserProfile} from "../../../models/user-profile";

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  public users: UserProfile[];
  public editableUser: UserProfile = new UserProfile();

  private subscriptions: Subscription[] = [];

  constructor(private userService: UserProfileService,
              private subsService: SubscriptionService,
              private modalService: BsModalService,
              private authService: AuthService) {
  }

  ngOnInit() {
    this.loadUsers();
  }

  public _updateUsers(): void {
    this.loadUsers();
  }

  public _deleteUser(id: string): void {
    this.subscriptions.push(this.userService.deleteUserProfile(id).subscribe(() => {
      this._updateUsers();
    }));
  }

  private refreshUser(): void {
    this.editableUser = new UserProfile();
  }

  private loadUsers(): void {
    this.subscriptions.push(this.userService.getUserProfileByRole("2").subscribe(users => {
      this.users = users as UserProfile[];
    }));
  }

  private blockUser(id: string): void {
    this.subscriptions.push(this.userService.blockUser(id).subscribe(() => {
      this.refreshUser();
      this._updateUsers();
    }));
  }

  private activateUser(id: string): void {
    this.subscriptions.push(this.userService.activateUser(id).subscribe(() => {
      this.refreshUser();
      this._updateUsers();
    }));
  }
}
