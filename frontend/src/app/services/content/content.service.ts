import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Content} from "../../models/content";
import {UserSubscription} from "../../models/user-subscription";
import {Wallet} from "../../models/wallet";

@Injectable({
  providedIn: 'root',
})
// Data service
export class ContentService {

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<Content[]> {
    return this.http.get<Content[]>('/api/content/all');
  }

  saveProduct(content: Content): Observable<Content> {
    return this.http.post<Content>('/api/content', content);
  }

  deleteProduct(id: string): Observable<void> {
    return this.http.delete<void>('/api/content/' + id);
  }

  getProductById(id: string): Observable<Content> {
    return this.http.get<Content>('/api/content/id/' + id);
  }
}
