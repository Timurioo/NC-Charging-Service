export class UserProfile {
  id: string;
  address: string;
  username: string;
  email: string;

  static cloneBase(userProfile: UserProfile): UserProfile {
    const clonedUserProfile: UserProfile = new UserProfile();
    clonedUserProfile.id = userProfile.id;
    clonedUserProfile.username = userProfile.username;
    clonedUserProfile.email = userProfile.email;
    clonedUserProfile.address = userProfile.address;
    return clonedUserProfile;
  }
}

export class UserProfileStr {
}
