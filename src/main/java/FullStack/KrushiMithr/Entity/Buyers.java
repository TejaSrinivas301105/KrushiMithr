package FullStack.KrushiMithr.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Buyers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buyerName;
    private String location;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true, unique = true)
    private Users users;
}
