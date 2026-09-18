package FullStack.KrushiMithr.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFarmerCropDto {

    @NotNull(message = "Vegetable ID is required")
    private Long vegetableId;
}
