import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserProfile} from "../../models/user-profile";


@Injectable()
// Data service
export class UserProfileService {

  public selectedUser: UserProfile;

  constructor(private http: HttpClient) {
  }

  getUserProfiles(): Observable<UserProfile[]> {
    return this.http.get<UserProfile[]>('/api/user');
  }

  saveUserProfile(userProfile: UserProfile): Observable<UserProfile> {
    return this.http.post<UserProfile>('/api/user/signup', userProfile);
  }

  deleteUserProfile(userProfileId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userProfileId);
  }

  getUserProfileByEmail(email: string): Observable<UserProfile> {
    return this.http.get<UserProfile>('/api/user/email/' + email);
  }

  getUserProfileById(id: string): Observable<UserProfile> {
    return this.http.get<UserProfile>('/api/user/id/' + id);
  }

  getUserProfileByRole(id: string): Observable<UserProfile[]> {
    return this.http.get<UserProfile[]>('/api/user/role/' + id);
  }

  blockUser(id: string): Observable<void> {
    return this.http.put<void>('/api/user/block/id/' + id, null);
  }

  activateUser(id: string): Observable<void> {
    return this.http.put<void>('/api/user/activate/id/' + id, null);
  }
}
