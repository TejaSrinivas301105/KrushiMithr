package FullStack.KrushiMithr.Dto;


import FullStack.KrushiMithr.Entity.MarketPrice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VegetableDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Veg_name;
    private String Image_url;

    private List<MarketPrice> prices;
}
