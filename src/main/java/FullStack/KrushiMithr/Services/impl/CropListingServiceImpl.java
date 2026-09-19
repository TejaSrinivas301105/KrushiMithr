package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.AddCropListingDto;
import FullStack.KrushiMithr.Dto.CropListingDto;
import FullStack.KrushiMithr.Entity.CropListing;
import FullStack.KrushiMithr.Entity.Farmer;
import FullStack.KrushiMithr.Entity.Vegetable;
import FullStack.KrushiMithr.Repository.CropListingRepo;
import FullStack.KrushiMithr.Repository.FarmersRepo;
import FullStack.KrushiMithr.Repository.VegtableRepo;
import FullStack.KrushiMithr.Services.CropListingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropListingServiceImpl implements CropListingService {

    private final CropListingRepo cropListingRepo;
    private final FarmersRepo farmersRepo;
    private final VegtableRepo vegtableRepo;
    private final ModelMapper modelMapper;

    @Override
    public CropListingDto addListing(Long farmerId, AddCropListingDto dto) {
        Farmer farmer = farmersRepo.findById(farmerId)
                .orElseThrow(() -> new IllegalArgumentException("Farmer not found"));
        Vegetable vegetable = vegtableRepo.findById(dto.getVegetableId())
                .orElseThrow(() -> new IllegalArgumentException("Vegetable not found"));

        CropListing listing = modelMapper.map(dto, CropListing.class);
        listing.setFarmer(farmer);
        listing.setVegetable(vegetable);

        return modelMapper.map(cropListingRepo.save(listing), CropListingDto.class);
    }

    @Override
    public List<CropListingDto> getListingsByFarmer(Long farmerId) {
        return cropListingRepo.findByFarmerId(farmerId).stream()
                .map(l -> modelMapper.map(l, CropListingDto.class))
                .toList();
    }

    @Override
    public List<CropListingDto> getAllListings() {
        return cropListingRepo.findAll().stream()
                .map(l -> modelMapper.map(l, CropListingDto.class))
                .toList();
    }

    @Override
    public Page<CropListingDto> getCropList(@PageableDefault(size = 10) Pageable pageable){
        return cropListingRepo.findAll(pageable)
                .map((element) -> modelMapper.map(element, CropListingDto.class));
    }
    @Override
    public void deleteListing(Long listingId) {
        cropListingRepo.deleteById(listingId);
    }
}
