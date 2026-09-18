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
@Table(name = "Farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Users users;

    private String farmerName;
    private String location;
    private String phoneNumber;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    private List<CropListing> listings;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    private List<FarmerCrop> crops;

}
