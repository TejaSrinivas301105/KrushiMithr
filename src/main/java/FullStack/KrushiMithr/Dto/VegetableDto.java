package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VegetableDto {
    private Long id;
    private String vegName;
    private String imageUrl;
    private List<MarketPricedto> prices;
}
