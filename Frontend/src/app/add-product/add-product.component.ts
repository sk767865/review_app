import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from "@angular/router";
import Swal from 'sweetalert2';
import { LoginService } from '../services/login.service';
import { ProductService } from '../services/product.service';
import { Product } from '../models/Product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  username:string='';
  existingProduct:any;

  showSpinner=false;








   addProductFrom = new FormGroup({
    productCode: new FormControl("", [Validators.required,Validators.pattern('[0-9]{4,10}')]),
    productBrand: new FormControl("", [Validators.required,Validators.pattern('^[a-zA-Z]+( [a-zA-Z]+)*$'),Validators.minLength(3)]),
    productName: new FormControl("", [Validators.required,Validators.pattern('^[a-zA-Z]+( [a-zA-Z0-9]+)*$'),Validators.minLength(3)])
  });

  constructor(private _snack: MatSnackBar, private router: Router, private productService:ProductService, private loginService:LoginService) { }

  ngOnInit(): void {
    this.username = this.loginService.getUser().username;
  }

  formSubmit(){



    if (this.addProductFrom.valid) {
      let productToAdd:Product = {
        productCode: this.addProductFrom.value.productCode, 
        productBrand: this.addProductFrom.value.productBrand, 
        productName: this.addProductFrom.value.productName, 
        username: this.username
      }
      this.productService.addProduct(productToAdd).subscribe(
        (data) => {
         
          Swal.fire('Success', 'Successfully raised the product for review!', 'success');
          return;
        },
        (error) => {
         
         
          this._snack.open('Product with the provided code already exists. You will be redirected to the product review page in 30 seconds', 'OK', {
            duration: 6000});

          this.productService.getProductByProductCode(this.addProductFrom.value.productCode).subscribe(
            (data) => {
              this.existingProduct = data;
            }
          );


          this.showSpinner=true;
          setTimeout(() => {
              this.router.navigate([`product-reviews/${this.existingProduct.productId}`]);
        }, 30000);



        
        }




      );


    }
  }

  get productCode(){
    return this.addProductFrom.get('productCode');
  }

  get productBrand(){
    return this.addProductFrom.get('productBrand');
  }

  get productName(){
    return this.addProductFrom.get('productName');
  }



  






}
