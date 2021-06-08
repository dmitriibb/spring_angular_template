import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BASE_API_URL} from "../constants";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HomeApiService {

  constructor(private http: HttpClient) { }

  public getHomeTest(): Observable<any> {
    return this.http.get(BASE_API_URL + '/home');
  }



}
