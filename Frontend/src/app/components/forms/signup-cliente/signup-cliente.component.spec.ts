import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupClienteComponent } from './signup-cliente.component';

describe('SignupClienteComponent', () => {
  let component: SignupClienteComponent;
  let fixture: ComponentFixture<SignupClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SignupClienteComponent]
    });
    fixture = TestBed.createComponent(SignupClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
