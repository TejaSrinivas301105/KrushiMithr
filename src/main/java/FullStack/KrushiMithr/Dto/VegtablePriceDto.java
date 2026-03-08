package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class VegtablePriceDto {

    private String vegName;
    private String imgUrl;
    private Double Prices;

}
