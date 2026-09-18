package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmersdto {
    private Long id;
    private String farmerName;
    private String location;
    private String phoneNumber;
    private List<CropListingDto> listings;
}
