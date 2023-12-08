import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Review } from 'src/app/models/Review';
import { ReviewService } from 'src/app/services/review.service';

@Component({
  selector: 'app-manage-reviews',
  templateUrl: './manage-reviews.component.html',
  styleUrls: ['./manage-reviews.component.css']
})
export class ManageReviewsComponent implements OnInit {

  pendingReviews:any=[];

  constructor(private reviewService:ReviewService, private _snack: MatSnackBar) { }

  ngOnInit(): void {
    this.reviewService.getAllPendingReviews().subscribe(
      (data) => {
        this.pendingReviews = data;
      }
    );
  }

  public approveReview(review:any){
    let reviewData:Review = {
      reviewId: review.reviewId,
      productId: review.productId, 
      reviewRating: review.reviewRating, 
      reviewHeading: review.reviewHeading, 
      reviewDescription: review.reviewDescription, 
      username: review.user.username,
      isApproved: true
    }
    this.reviewService.updateReview(reviewData).subscribe(
      (data) => {
        this._snack.open('Successfully Approved the review!', 'OK', {
          duration: 3000
        });
        this.updatePendingReviewsList();
        return;
      },
      (error) => {
        this._snack.open('Something went wrong', 'OK', {
          duration: 3000
        });
      }
    );
  }

  public discardReview(review:Review){
    this.reviewService.deleteReview(review.reviewId).subscribe(
      (data) => {
        this._snack.open('Successfully Discarded the review!', 'OK', {
          duration: 3000
        });
        this.updatePendingReviewsList();
        return;
      },
      (error) => {
        this._snack.open('Something went wrong', 'OK', {
          duration: 3000
        });
      }
    );
  }

  private updatePendingReviewsList(){
    this.reviewService.getAllPendingReviews().subscribe(
      (data) => {
        this.pendingReviews = data;
      }
    );
  }

}
