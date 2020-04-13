import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { Customer } from './customer';

@Injectable()
export class BankmgmtService {
    bankUrl = "http://localhost:8888/api/account/";
    constructor(private http: HttpClient) {
     }

    getAllCustomers(): Observable<Customer[]> {
        return this.http.get<Customer[]>(this.bankUrl+"getAllAccounts").pipe(
            tap(data => console.log(this.bankUrl+"getAllCustomers"+"Number of Customer: " + data.length)),
            catchError(this.handleError)
        );
    }


     private handleError(error: any) {
        console.error(error);
        return throwError(error);
    }


}