package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyerDto {
    private Long id;
    private String buyerName;
    private String location;
    private String phoneNumber;
    private String userName;
}
