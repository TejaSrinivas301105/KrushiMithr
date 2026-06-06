package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponedto {
    String JWT;
    Long useId;
}
