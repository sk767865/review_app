import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any, filterString:string) {
    if(value.length === 0 || filterString==''){
      return value;
    }

    const products = [];
    for(const product of value){
      if(product['productCode'].toLowerCase().trim().includes(filterString.toLowerCase().trim()) || product['productBrand'].toLowerCase().trim().includes(filterString.toLowerCase().trim()) || product['productName'].toLowerCase().trim().includes(filterString.toLowerCase().trim())){
        products.push(product);
      }
    }
    return products;
  }

}
