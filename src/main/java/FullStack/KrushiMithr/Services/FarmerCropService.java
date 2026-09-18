package FullStack.KrushiMithr.Services;

import FullStack.KrushiMithr.Dto.AddFarmerCropDto;
import FullStack.KrushiMithr.Dto.FarmerCropDto;

import java.util.List;

public interface FarmerCropService {
    FarmerCropDto registerCrop(Long farmerId, AddFarmerCropDto dto);
    List<FarmerCropDto> getCropsByFarmer(Long farmerId);
    List<FarmerCropDto> getFarmersByVegetable(Long vegetableId);
}
