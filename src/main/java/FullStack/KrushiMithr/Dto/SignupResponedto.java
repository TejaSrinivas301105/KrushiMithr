package FullStack.KrushiMithr.Dto;

import FullStack.KrushiMithr.Entity.type.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignupResponedto {
    private Long id;
    private String userName;
    @Enumerated(EnumType.STRING)
    private Role role;
}
