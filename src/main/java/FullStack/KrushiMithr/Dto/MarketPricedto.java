package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketPricedto {
    private Long id;
    private Double price;
    private String marketPlace;
    private LocalDate priceDate;
    private String vegetableName;
}
