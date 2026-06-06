package FullStack.KrushiMithr.Dto;


import FullStack.KrushiMithr.Entity.type.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestdto {

    String username;
    String password;

}
