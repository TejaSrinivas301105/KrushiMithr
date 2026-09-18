package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropListingDto {
    private Long id;
    private String vegetableName;
    private String quantity;
    private String sellingPrice;
    private String imageUrl;
    private String location;
}
