import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Review } from '../models/Review';
import rootUrl from './properties';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http:HttpClient) { }

  public getAllApprovedReviewsByProductId(productId:number){
    return this.http.get(`${rootUrl}/review/${productId}`);
  }

  public getAllPendingReviews(){
    return this.http.get(`${rootUrl}/review/pending`);
  }

  public addReviewToProduct(reviewData:Review){
    return this.http.post(`${rootUrl}/review`, reviewData);
  }

  public updateReview(reviewData:Review){
    return this.http.put(`${rootUrl}/review`, reviewData);
  }

  public deleteReview(reviewId:any){
    return this.http.delete(`${rootUrl}/review/${parseInt(reviewId)}`);
  }

}
