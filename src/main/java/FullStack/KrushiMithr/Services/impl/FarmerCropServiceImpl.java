package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.AddFarmerCropDto;
import FullStack.KrushiMithr.Dto.FarmerCropDto;
import FullStack.KrushiMithr.Entity.Farmer;
import FullStack.KrushiMithr.Entity.FarmerCrop;
import FullStack.KrushiMithr.Entity.Vegetable;
import FullStack.KrushiMithr.Repository.FarmerCropRepo;
import FullStack.KrushiMithr.Repository.FarmersRepo;
import FullStack.KrushiMithr.Repository.VegtableRepo;
import FullStack.KrushiMithr.Services.FarmerCropService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmerCropServiceImpl implements FarmerCropService {

    private final FarmerCropRepo farmerCropRepo;
    private final FarmersRepo farmersRepo;
    private final VegtableRepo vegtableRepo;
    private final ModelMapper modelMapper;

    @Override
    public FarmerCropDto registerCrop(Long farmerId, AddFarmerCropDto dto) {
        Farmer farmer = farmersRepo.findById(farmerId)
                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
        Vegetable vegetable = vegtableRepo.findById(dto.getVegetableId())
                .orElseThrow(() -> new IllegalArgumentException("Vegetable not found"));

        FarmerCrop farmerCrop = new FarmerCrop();
        farmerCrop.setFarmer(farmer);
        farmerCrop.setVegetable(vegetable);

        return modelMapper.map(farmerCropRepo.save(farmerCrop), FarmerCropDto.class);
    }

    @Override
    public List<FarmerCropDto> getCropsByFarmer(Long farmerId) {
        return farmerCropRepo.findByFarmerId(farmerId).stream()
                .map(fc -> modelMapper.map(fc, FarmerCropDto.class))
                .toList();
    }

    @Override
    public List<FarmerCropDto> getFarmersByVegetable(Long vegetableId) {
        return farmerCropRepo.findByVegetableId(vegetableId).stream()
                .map(fc -> modelMapper.map(fc, FarmerCropDto.class))
                .toList();
    }
}
