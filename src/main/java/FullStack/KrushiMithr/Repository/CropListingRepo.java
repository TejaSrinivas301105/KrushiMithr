package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.CropListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropListingRepo extends JpaRepository<CropListing, Long> {
    List<CropListing> findByFarmerId(Long farmerId);
    List<CropListing> findByVegetableId(Long vegetableId);
    Page<CropListing> findAll(Pageable pageable);
}
