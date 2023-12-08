import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from "@angular/router";
import { LoginService } from 'src/app/services/login.service';
import { ShareDataService } from 'src/app/services/share-data.service';
import { StatisticsService } from 'src/app/services/statistics.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  searchForm = new FormGroup({
    productCode: new FormControl("",[Validators.pattern('[0-9]{4,10}')]),
    productBrand: new FormControl("",[Validators.pattern('^[a-zA-Z]+( [a-zA-Z]+)*$'),Validators.minLength(3)]),
    productName: new FormControl("",[Validators.pattern('^[a-zA-Z]+( [a-zA-Z0-9]+)*$'),Validators.minLength(3)])
  });

  constructor(public loginService:LoginService, private statisticsService:StatisticsService, private shareDataService:ShareDataService, private _snack: MatSnackBar, private router: Router) { }

  usersCount:any;
  productsCount:any;
  reviewsCount:any;

  ngOnInit(): void {
    this.statisticsService.getUsersCount().subscribe((data)=>this.usersCount = data);
    this.statisticsService.getProductsCount().subscribe((data)=>this.productsCount = data);
    this.statisticsService.getReviewsCount().subscribe((data)=>this.reviewsCount = data);
  }

  formSubmit(){
    if(this.searchForm.value.productCode=='' && this.searchForm.value.productBrand=='' &&this.searchForm.value.productName==''){
      this._snack.open('Please fill atleast one field!', 'OK', {
        duration: 3000
      });
      return;
    }
    if (this.searchForm.valid) {
      this.shareDataService.changeData(this.searchForm.value);
      this.router.navigate(["/search-result"]);
    }
  }

get productCode(){
  return this.searchForm.get('productCode');
}

get productBrand(){
  return this.searchForm.get('productBrand');
}

get productName(){
  return this.searchForm.get('productName');
}

}
