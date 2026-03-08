package FullStack.KrushiMithr.Dto;

import FullStack.KrushiMithr.Entity.Vegetable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMarketPricedto {

    @NotBlank(message = "price is required")
    private Double price;
    @NotBlank(message = "MarketPlace is required")
    private String MarketPlace;
    @NotBlank(message = "Vegetable Name is required")
    private Vegetable VegetableName;
}
