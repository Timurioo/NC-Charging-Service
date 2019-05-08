import {UserProfile} from "./user-profile";
import {UserSubscription} from "./user-subscription";

export class Content {
  id: string;
  pictureUrl: string;
  itemName: string;
  description: string;
  cost: string;
  userProfile: UserProfile;

  static cloneBase(content: Content): Content {
    const clonedContent: Content = new Content();
    clonedContent.id = content.id;
    clonedContent.pictureUrl = content.pictureUrl;
    clonedContent.itemName = content.itemName;
    clonedContent.description = content.description;
    clonedContent.cost = content.cost;
    clonedContent.userProfile = content.userProfile;
    return clonedContent;
  }
}

