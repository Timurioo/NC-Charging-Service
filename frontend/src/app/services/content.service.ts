import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Content} from "../modules/homepage/components/content-table/models/content";

@Injectable({
  providedIn: 'root',
})
// Data service
export class ContentService {

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getProducts(): Observable<Content[]> {
    return this.http.get<Content[]>('/api/content/all');
  }

  saveProduct(content: Content): Observable<Content> {
    return this.http.post<Content>('/api/content', content);
  }

  deleteProduct(contentId: string): Observable<void> {
    return this.http.delete<void>('/api/content/' + contentId);
  }

  getContentById(id: string): Observable<Content> {
    return this.http.get<Content>('/api/content/' + id);
  }

}
