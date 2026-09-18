package FullStack.KrushiMithr.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCropListingDto {

    @NotNull(message = "Vegetable ID is required")
    private Long vegetableId;

    @NotBlank(message = "Quantity is required")
    private String quantity;

    @NotBlank(message = "Selling price is required")
    private String sellingPrice;

    @NotBlank(message = "Location is required")
    private String location;

    private String imageUrl;
}
