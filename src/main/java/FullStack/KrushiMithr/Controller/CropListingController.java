package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.AddCropListingDto;
import FullStack.KrushiMithr.Dto.CropListingDto;
import FullStack.KrushiMithr.Services.CropListingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/listings")
public class CropListingController {

    private final CropListingService cropListingService;

    @PostMapping("/farmer/{farmerId}")
    public ResponseEntity<CropListingDto> addListing(
            @PathVariable Long farmerId,
            @RequestBody @Valid AddCropListingDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cropListingService.addListing(farmerId, dto));
    }

    @GetMapping
    public ResponseEntity<List<CropListingDto>> getAllListings() {
        return ResponseEntity.ok(cropListingService.getAllListings());
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<CropListingDto>> getListingsByFarmer(@PathVariable Long farmerId) {
        return ResponseEntity.ok(cropListingService.getListingsByFarmer(farmerId));
    }

    @DeleteMapping("/{listingId}")
    public ResponseEntity<Void> deleteListing(@PathVariable Long listingId) {
        cropListingService.deleteListing(listingId);
        return ResponseEntity.noContent().build();
    }
}
