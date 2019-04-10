export class Content {
  id: string;
  pictureUrl: string;
  itemName: string;
  description: string;
  cost: string;

  static clonedBase(content: Content): Content {
    const clonedContent: Content = new Content();
    clonedContent.id = content.id;
    clonedContent.pictureUrl = content.pictureUrl;
    clonedContent.itemName = content.itemName;
    clonedContent.description = content.description;
    clonedContent.cost = content.cost;
    return clonedContent;
  }
}

export class ContentStr {

}
