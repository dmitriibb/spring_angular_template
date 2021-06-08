import { Component, OnInit } from '@angular/core';
import {HomeApiService} from "../../service/home-api.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  data = '';

  constructor(private  homeApiService: HomeApiService) { }

  ngOnInit(): void {
  }

  onBtnClick() {
    this.homeApiService.getHomeTest().subscribe(res => this.data = res.data);
  }

}
