import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingCustomerComponent } from './billing-customer.component';

describe('BillingCustomerComponent', () => {
  let component: BillingCustomerComponent;
  let fixture: ComponentFixture<BillingCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BillingCustomerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillingCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
