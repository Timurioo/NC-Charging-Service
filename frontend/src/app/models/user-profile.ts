import {Role} from "./role";

export class UserProfile {
  id: string;
  email: string;
  firstName: string;
  lastName: string;
  password: string;
  isBlocked: string;
  role: Role;

  static cloneBase(userProfile: UserProfile): UserProfile {
    const clonedUserProfile: UserProfile = new UserProfile();
    clonedUserProfile.id = userProfile.id;
    clonedUserProfile.email = userProfile.email;
    clonedUserProfile.firstName = userProfile.firstName;
    clonedUserProfile.lastName = userProfile.lastName;
    clonedUserProfile.password = userProfile.password;
    clonedUserProfile.role = userProfile.role;
    clonedUserProfile.isBlocked = userProfile.isBlocked;
    return clonedUserProfile;
  }
}

export class AuthToken {
  token: string;
}
