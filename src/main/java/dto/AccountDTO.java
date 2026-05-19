package dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AccountDTO {
    private String officePhone;
    private String website;
    private String fax;
    private String billingAddressStreet;
    private String billingAddressCity;
    private String billingAddressStateRegion;
    private String billingAddressPostalCode;
    private String billingAddressCountry;
    private String shippingAddressStreet;
    private String shippingAddressCity;
    private String shippingAddressStateRegion;
    private String shippingAddressPostalCode;
    private String shippingAddressCountry;
    private String annualRevenue;
    private String employees;
    @Builder.Default
    private String description = "There should be a long description here";
    private String type;
    private String industry;
}