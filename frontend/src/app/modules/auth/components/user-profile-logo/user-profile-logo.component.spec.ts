import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserProfileLogoComponent } from './user-profile-logo.component';

describe('UserProfileLogoComponent', () => {
  let component: UserProfileLogoComponent;
  let fixture: ComponentFixture<UserProfileLogoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserProfileLogoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserProfileLogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
