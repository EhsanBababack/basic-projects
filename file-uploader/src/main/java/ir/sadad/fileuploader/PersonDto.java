package ir.sadad.fileuploader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String firstName;
    private String lastName;
    private String nationalId;
    private String customerNo;
    private String mobileNumber;
    private String fatherName;
}
