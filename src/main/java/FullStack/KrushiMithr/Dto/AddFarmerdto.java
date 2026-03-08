package FullStack.KrushiMithr.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.bridge.IMessage;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFarmerdto {

    @NotBlank(message = "Name is required")
    private String farmerName;

    @NotBlank(message = "Crop name required")
    private String cropName;

    @NotBlank(message = "location name required")
    private String location;

    @NotBlank(message = "Phone Number name required")
    @Size(min = 10, max = 11, message = "enter valid number")
    private String phoneNumber;

    @NotBlank(message = "Quantity required")
    private String quantity;

    @NotBlank(message = "Selling Price required")
    private String sellingPrice;

    private String imageUrl;
}
