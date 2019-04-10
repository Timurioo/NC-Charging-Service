import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserProfile} from "../modules/auth/models/user-profile";


@Injectable()
// Data service
export class UserProfileService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getUserProfiles(): Observable<UserProfile[]> {
    return this.http.get<UserProfile[]>('/api/user');
  }

  saveUserProfile(userProfile: UserProfile): Observable<UserProfile> {
    return this.http.post<UserProfile>('/api/user', userProfile);
  }

  deleteUserProfile(userProfileId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userProfileId);
  }

  getUserProfileById(id: string): Observable<UserProfile> {
    return this.http.get<UserProfile>('/api/user/' + id);
  }

}
