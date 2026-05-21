package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactsDTO {
    private String firstName;
    private String officePhone;
    private String jobTitle;
    private String lastName;
    private String mobile;
    private String department;
    private String fax;
}
