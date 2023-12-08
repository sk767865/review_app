import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { ReviewService } from 'src/app/services/review.service';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { LoginService } from 'src/app/services/login.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Review } from'../../models/Review';

@Component({
  selector: 'app-product-reviews',
  templateUrl: './product-reviews.component.html',
  styleUrls: ['./product-reviews.component.css']
})
export class ProductReviewsComponent implements OnInit {

  productId:any;
  productData:any;
  allReviews:any=[];
  username:string='';
  rating:number=0;

  reviewForm = new FormGroup({
    reviewHeading: new FormControl("", [Validators.required]),
    reviewDescription: new FormControl("", [Validators.required, Validators.minLength(20), Validators.maxLength(400)]),
    reviewRating: new FormControl('', [Validators.required])
  });

  constructor(private activatedRoute:ActivatedRoute, private router:Router, private productService:ProductService, private reviewService:ReviewService, private loginService:LoginService, private _snack: MatSnackBar) { }

  ngOnInit(): void {
    // Get product ID
    this.productId = this.activatedRoute.snapshot.params['productId'];
    // Get product details
    this.productService.getProductByProductId(this.productId).subscribe(
      (data) => {
        this.productData=data;
      }
    );
    // Get product reviews
      this.reviewService.getAllApprovedReviewsByProductId(this.productId).subscribe(
        (data) => {
          this.allReviews = data;
        }
      );
    // Get username of logged in user
    this.username = this.loginService.getUser().username;
  }

  formSubmit(){
    if (this.reviewForm.valid) {
      let reviewDetails:Review = {
        reviewRating: this.reviewForm.value.reviewRating,
        reviewHeading: this.reviewForm.value.reviewHeading,
        reviewDescription: this.reviewForm.value.reviewDescription,
        username: this.username,
        productId: parseInt(this.productId)
      }
      console.log(reviewDetails);
      this.reviewService.addReviewToProduct(reviewDetails).subscribe(
        (data) => {

        },
        (error) => {
          this._snack.open('Something went wrong.', 'OK', {
            duration: 3000
          });
          return;
        }
      );
      this.reviewForm.reset();
      this._snack.open('Success! Your review will be visible once approved.', 'OK', {
        duration: 3000
      });
  }
  }

  get reviewHeading(){
    return this.reviewForm.get('reviewHeading');
  }

  get reviewDescription(){
    return this.reviewForm.get('reviewDescription');
  }

}
