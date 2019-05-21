import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductPageBtnComponent } from './product-page-btn.component';

describe('ProductPageBtnComponent', () => {
  let component: ProductPageBtnComponent;
  let fixture: ComponentFixture<ProductPageBtnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductPageBtnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductPageBtnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
