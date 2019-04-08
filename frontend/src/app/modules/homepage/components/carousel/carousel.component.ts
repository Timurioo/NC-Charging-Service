import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
  
  constructor() {
   }

  ngOnInit() {
  }
  
  image: Array<any> = [
    '../assets/images/banner-2.jpg',
    '../assets/images/banner-3.png',
    '../assets/images/banner-4.jpg'
  ];
}
