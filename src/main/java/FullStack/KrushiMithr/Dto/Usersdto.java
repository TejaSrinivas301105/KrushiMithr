package FullStack.KrushiMithr.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usersdto {
    private Long id;
    private String userName;
    private String role;
}
