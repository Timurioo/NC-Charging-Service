import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Wallet} from "../../models/wallet";
import {UserProfile} from "../../models/user-profile";

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  constructor(private http: HttpClient) {
  }

  getWallets(): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('/api/billing/all');
  }

  getWalletsByUser(userId: string): Observable<Wallet[]> {
    return this.http.get<Wallet[]>('/api/billing/user/' + userId);
  }

  saveWallet(wallet: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('/api/billing/new', wallet);
  }

  deleteWallet(id: string): Observable<void> {
    return this.http.delete<void>('/api/billing/' + id);
  }

  getWalletByWalletId(walletId: string): Observable<Wallet> {
    return this.http.get<Wallet>('/api/billing/wallet-id/' + walletId);
  }

  getWalletById(id: string): Observable<Wallet> {
    return this.http.get<Wallet>('/api/billing/id/' + id);
  }
}
