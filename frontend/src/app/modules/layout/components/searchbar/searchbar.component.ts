import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, NavigationExtras, Router} from "@angular/router";
import {Content} from "../../../../models/content";
import {ContentService} from "../../../../services/content/content.service";
import {Title} from "@angular/platform-browser";
import {SubscriptionService} from "../../../../services/subscription/subscription.service";

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent implements OnInit {

  public product: Content;
  public loaded: boolean = false;
  public productExists: boolean = false;
  public searchStr: string;

  constructor(private activeRoute: ActivatedRoute,
              private productService: ContentService,
              private router: Router,
              private titleService: Title,
              private subsService: SubscriptionService) {
  }

  ngOnInit() {
    this.searchProduct();
  }

  private searchProduct():void{
    if(this.searchStr){
      this.productService.getProductByItemName(this.searchStr).subscribe(product =>{
        if(product != null){
          this.productExists = true;
          this.subsService.selectedProduct = product;
          this.router.navigate(['/product/' + this.subsService.selectedProduct.id]);
        }
        setTimeout(()=>{this.loaded = true}, 500);
      }, error1 => {
        this.toErrorPage(error1);
      })
    }
  }

  public toErrorPage(error1){
    let nav: NavigationExtras = {
      queryParams:{
        "code": error1.status,
        "message": error1.statusText
      }
    };
    this.router.navigate(['/**'], nav)
  }

}
