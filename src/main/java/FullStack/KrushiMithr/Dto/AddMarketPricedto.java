package FullStack.KrushiMithr.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMarketPricedto {

    @NotNull(message = "Price is required")
    private Double price;

    @NotBlank(message = "MarketPlace is required")
    private String marketPlace;

    @NotNull(message = "Vegetable ID is required")
    private Long vegetableId;
}
