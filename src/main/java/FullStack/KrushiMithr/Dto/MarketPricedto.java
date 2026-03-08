package FullStack.KrushiMithr.Dto;


import FullStack.KrushiMithr.Entity.Vegetable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketPricedto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;
    private String MarketPlace;

    @CreationTimestamp
    private LocalDate priceDate;

    private Vegetable vegetableName;
}
