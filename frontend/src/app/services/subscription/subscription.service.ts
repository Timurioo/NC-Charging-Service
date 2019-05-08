import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {UserSubscription} from "../../models/user-subscription";
import {HttpClient} from "@angular/common/http";
import {Wallet} from "../../models/wallet";
import {Content} from "../../models/content";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  public selectedWallet: Wallet;
  public selectedProduct: Content;

  constructor(private http: HttpClient) { }

  getSubs(): Observable<UserSubscription[]> {
    return this.http.get<UserSubscription[]>('/api/subscription/all');
  }

  savSubs(subs: UserSubscription): Observable<UserSubscription> {
    return this.http.post<UserSubscription>('/api/subscription/new', subs);
  }

  deleteSubs(id: string): Observable<void> {
    return this.http.delete<void>('/api/subscription/' + id);
  }

  getSubsByWallet(walletId: string): Observable<UserSubscription[]> {
    return this.http.get<UserSubscription[]>('/api/subscription/wallet/' + walletId);
  }

  getSubsById(id: string): Observable<UserSubscription> {
    return this.http.get<UserSubscription>('/api/subscription/id/' + id);
  }
}
