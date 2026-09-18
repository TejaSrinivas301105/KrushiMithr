package FullStack.KrushiMithr.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String VegName;
    private String Image_url;
    @OneToMany(mappedBy = "vegetable", cascade = CascadeType.ALL)
    private List<MarketPrice> prices;

}
