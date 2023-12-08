import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { ShareDataService } from 'src/app/services/share-data.service';

@Component({
  selector: 'app-products-result',
  templateUrl: './products-result.component.html',
  styleUrls: ['./products-result.component.css']
})
export class ProductsResultComponent implements OnInit {

  filteredString:string='';
  userSearchCriteria=null;
  productsData:any='';
  
  constructor(private shareDataService:ShareDataService, private productService:ProductService) { }

  ngOnInit(): void {
    this.shareDataService.currentData.subscribe(
      (data) => {
        this.userSearchCriteria = data;
      }
    );

    if(this.userSearchCriteria!=null){
      this.productService.getProductBySearchCriteria(this.userSearchCriteria).subscribe(
        (data)=>{
          
          this.productsData = data;
        }
      );
    }
  }

}
