package FullStack.KrushiMithr.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFarmerdto {

    @NotBlank(message = "Name is required")
    private String farmerName;

    @NotBlank(message = "Location required")
    private String location;

    @NotBlank(message = "Phone number required")
    private String phoneNumber;
}
