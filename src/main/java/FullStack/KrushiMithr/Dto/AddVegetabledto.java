package FullStack.KrushiMithr.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddVegetabledto {

    @NotBlank(message = "Name is required")
    private String Veg_name;

    @NotBlank(message = "url is required")
    private String Image_url;


}
