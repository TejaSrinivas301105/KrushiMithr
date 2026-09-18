package FullStack.KrushiMithr.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "crop_listings")
public class CropListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which farmer is selling?
    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;

    // What crop is being sold?
    @ManyToOne
    @JoinColumn(name = "vegetable_id", nullable = false)
    private Vegetable vegetable;

    private String quantity;
    private String sellingPrice;
    private String imageUrl;
    private String location;
}
