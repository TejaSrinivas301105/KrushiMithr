package FullStack.KrushiMithr.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBuyerDto {

    @NotBlank(message = "Buyer name is required")
    private String buyerName;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
}
