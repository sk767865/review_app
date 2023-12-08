import { Injectable } from '@angular/core';
import { Subject, BehaviorSubject, Observable,ReplaySubject } from 'rxjs';
import { UserSearchCriteria } from '../models/UserSearchCriteria';

@Injectable({
  providedIn: 'root'
})
export class ShareDataService {

  constructor() { }

  public editDataDetails: any = [];
  public subject = new Subject<any>();
  private dataSource = new  BehaviorSubject(this.editDataDetails);
  currentData = this.dataSource.asObservable();

  changeData(userSearchCriteria: UserSearchCriteria) {
    this.dataSource.next(userSearchCriteria)
  }

}
