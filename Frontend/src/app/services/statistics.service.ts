import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import rootUrl from './properties';
@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http:HttpClient) { }

  public getUsersCount(){
    return this.http.get(`${rootUrl}/stats/users`);
  }

  public getProductsCount(){
    return this.http.get(`${rootUrl}/stats/products`);
  }

  public getReviewsCount(){
    return this.http.get(`${rootUrl}/stats/reviews`);
  }

}
