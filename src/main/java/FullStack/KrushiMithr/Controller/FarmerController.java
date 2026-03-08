package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.AddFarmerdto;
import FullStack.KrushiMithr.Dto.Farmersdto;

import FullStack.KrushiMithr.Services.ServiceImple;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
public class FarmerController {


    private final ServiceImple farmerService;

//    @PostMapping("/Farmers/details")
//    public ResponseEntity<Farmersdto> createFarmers(
//            @RequestPart("image") MultipartFile image,
//            @RequestPart("farmers") Farmersdto farmersdto
//            ) throws Exception {
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(farmerService.createFarmers(farmersdto));
//    }



    @PostMapping("/Farmers/details")
    public ResponseEntity<Farmersdto>  createFarmers(@RequestBody @Valid AddFarmerdto addFarmerdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(farmerService.createFarmers(addFarmerdto));
    }

    @GetMapping("/")
    public List<Farmersdto> getAllFarmers(){
        return farmerService.getALlFarmers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmersdto> getFarmerById(@PathVariable Long id){
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }
}
