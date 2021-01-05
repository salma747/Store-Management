package tn.iit.storeManagement.dto;

import lombok.*;
import tn.iit.storeManagement.models.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {
    private long id;
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String name;
        @NotNull
    private long categoryId;
        @NotNull
    @Size(min = 5)
    private String categoryName;
    @NotNull
    private String ageType;
        @NotNull
    private float posology;
    @NotNull
    private float price;
    @NotNull
    private Date expirationDate;
}
