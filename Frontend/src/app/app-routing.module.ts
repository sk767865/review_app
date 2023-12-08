import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterUserComponent } from './pages/register-user/register-user.component';
import {ProductsResultComponent} from './pages/products-result/products-result.component'
import { ProductReviewsComponent } from './pages/product-reviews/product-reviews.component';
import { AddProductComponent } from './add-product/add-product.component'
import { ManageReviewsComponent } from './admin/manage-reviews/manage-reviews.component'
import { AdminAuthGuard } from './guards/admin-auth.guard';
import { UserAuthGuard } from './guards/user-auth.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  }
  ,{
    path: 'register',
    component: RegisterUserComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'search-result',
    component: ProductsResultComponent,
    pathMatch: 'full',
    canActivate: [UserAuthGuard]
  },
  {
    path: 'product-reviews/:productId',
    component: ProductReviewsComponent,
    canActivate: [UserAuthGuard]
  },
  {
    path: 'raise-for-review',
    component: AddProductComponent,
    canActivate: [UserAuthGuard]
  },
  {
    path: 'manage-reviews',
    component: ManageReviewsComponent,
    canActivate: [AdminAuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
