package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.AddMarketPricedto;
import FullStack.KrushiMithr.Dto.AddVegetabledto;
import FullStack.KrushiMithr.Dto.MarketPricedto;
import FullStack.KrushiMithr.Dto.VegtablePriceDto;
import FullStack.KrushiMithr.Entity.MarketPrice;
import FullStack.KrushiMithr.Entity.Vegetable;
import FullStack.KrushiMithr.Repository.VegtableRepo;
import FullStack.KrushiMithr.Services.MarketPriceService;
import FullStack.KrushiMithr.Services.ServiceImple;
import FullStack.KrushiMithr.Services.impl.SupaBaseService;
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
    private final SupaBaseService storageService;
    private final VegtableRepo vegtableRepo;


    @PostMapping("/Farmers/Vegetable")
    public ResponseEntity<Vegetable> addVegetable(
            @RequestBody AddVegetabledto dto
    ) {

        Vegetable veg = new Vegetable();
        veg.setVegName(dto.getVeg_name());
        veg.setImage_url(dto.getImage_url());

        Vegetable saved = vegtableRepo.save(veg);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
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
