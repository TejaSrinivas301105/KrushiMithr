package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.AddMarketPricedto;
import FullStack.KrushiMithr.Dto.AddVegetabledto;
import FullStack.KrushiMithr.Dto.MarketPricedto;
import FullStack.KrushiMithr.Dto.VegetableDto;
import FullStack.KrushiMithr.Dto.VegtablePriceDto;
import FullStack.KrushiMithr.Services.MarketPriceService;
import FullStack.KrushiMithr.Services.ServiceImple;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VegtableController {
    private final ServiceImple serviceImple;
    private final MarketPriceService marketPriceService;


    @PostMapping("/Farmers/Vegetable")
    public ResponseEntity<VegetableDto> addVegetable(@RequestBody AddVegetabledto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(marketPriceService.addVegetables(dto));
    }

    @GetMapping("/Vegetables")
    public ResponseEntity<List<VegtablePriceDto>> getVegetables_prices(){
        return ResponseEntity.ok(marketPriceService.getAllVeg_prices());
    }

    @PostMapping("/Prices")

    public ResponseEntity<MarketPricedto> setPrices(@RequestBody AddMarketPricedto addMarketPricedto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(marketPriceService.addMarketPrice(addMarketPricedto));
    }

}
