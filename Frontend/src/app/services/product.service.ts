import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserSearchCriteria } from '../models/UserSearchCriteria'
import rootUrl from './properties';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public getProductBySearchCriteria(userSearchCriteria:UserSearchCriteria){
    return this.http.post(`${rootUrl}/product/criteria`, userSearchCriteria);
  }

  public getProductByProductId(productId:number){
    return this.http.get(`${rootUrl}/product/${productId}`);
  }

  public getProductByProductCode(productCode:string){
    return this.http.get(`${rootUrl}/product/byCode/${productCode}`)
  }

  public addProduct(product:any){
    return this.http.post(`${rootUrl}/product`, product);
  }

}


















