package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.FarmerCrop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerCropRepo extends JpaRepository<FarmerCrop, Long> {
    List<FarmerCrop> findByFarmerId(Long farmerId);
    List<FarmerCrop> findByVegetableId(Long vegetableId);
}
