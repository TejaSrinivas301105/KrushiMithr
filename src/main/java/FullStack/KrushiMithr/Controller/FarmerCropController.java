package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.AddFarmerCropDto;
import FullStack.KrushiMithr.Dto.FarmerCropDto;
import FullStack.KrushiMithr.Services.FarmerCropService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/farmer-crops")
public class FarmerCropController {

    private final FarmerCropService farmerCropService;

    // Register a crop that a farmer grows
    @PostMapping("/farmer/{farmerId}")
    public ResponseEntity<FarmerCropDto> registerCrop(
            @PathVariable Long farmerId,
            @RequestBody @Valid AddFarmerCropDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(farmerCropService.registerCrop(farmerId, dto));
    }

    // What does this farmer grow?
    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<FarmerCropDto>> getCropsByFarmer(@PathVariable Long farmerId) {
        return ResponseEntity.ok(farmerCropService.getCropsByFarmer(farmerId));
    }

    // Which farmers grow this vegetable?
    @GetMapping("/vegetable/{vegetableId}")
    public ResponseEntity<List<FarmerCropDto>> getFarmersByVegetable(@PathVariable Long vegetableId) {
        return ResponseEntity.ok(farmerCropService.getFarmersByVegetable(vegetableId));
    }
}
