package FullStack.KrushiMithr.Dto;

import FullStack.KrushiMithr.Entity.type.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestdto {

    String username;
    String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
