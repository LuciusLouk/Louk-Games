import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalSignupComponent } from './modal-signup.component';

describe('ModalSignupComponent', () => {
  let component: ModalSignupComponent;
  let fixture: ComponentFixture<ModalSignupComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModalSignupComponent]
    });
    fixture = TestBed.createComponent(ModalSignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
