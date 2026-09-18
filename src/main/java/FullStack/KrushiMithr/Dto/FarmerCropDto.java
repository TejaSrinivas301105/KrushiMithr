package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerCropDto {
    private Long id;
    private String farmerName;
    private String vegetableName;
}
