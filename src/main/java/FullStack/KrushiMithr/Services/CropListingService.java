package FullStack.KrushiMithr.Services;

import FullStack.KrushiMithr.Dto.AddCropListingDto;
import FullStack.KrushiMithr.Dto.CropListingDto;
import FullStack.KrushiMithr.Entity.CropListing;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CropListingService {
    CropListingDto addListing(Long farmerId, AddCropListingDto dto);
    List<CropListingDto> getListingsByFarmer(Long farmerId);
    List<CropListingDto> getAllListings();
    void deleteListing(Long listingId);
    Page<CropListingDto> getCropList(Pageable pageable);
}
