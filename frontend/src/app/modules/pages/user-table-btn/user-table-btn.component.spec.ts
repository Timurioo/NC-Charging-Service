import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTableBtnComponent } from './user-table-btn.component';

describe('UserTableBtnComponent', () => {
  let component: UserTableBtnComponent;
  let fixture: ComponentFixture<UserTableBtnComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTableBtnComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTableBtnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
