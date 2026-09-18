package FullStack.KrushiMithr.Services;

import FullStack.KrushiMithr.Dto.AddCropListingDto;
import FullStack.KrushiMithr.Dto.CropListingDto;

import java.util.List;

public interface CropListingService {
    CropListingDto addListing(Long farmerId, AddCropListingDto dto);
    List<CropListingDto> getListingsByFarmer(Long farmerId);
    List<CropListingDto> getAllListings();
    void deleteListing(Long listingId);
}
