export interface Review {
    reviewId?:number;
    productId:number;
    reviewRating:number;
    reviewHeading:string;
    reviewDescription:string;
    username:string;
    isApproved?:boolean;
}
