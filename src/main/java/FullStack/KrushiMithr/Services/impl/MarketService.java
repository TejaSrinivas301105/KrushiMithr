package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.*;
import FullStack.KrushiMithr.Entity.MarketPrice;
import FullStack.KrushiMithr.Entity.Vegetable;
import FullStack.KrushiMithr.Repository.MarketPriceRepo;
import FullStack.KrushiMithr.Repository.VegtableRepo;
import FullStack.KrushiMithr.Services.MarketPriceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Data
@Service

public class MarketService implements MarketPriceService {

    private  final VegtableRepo vegtableRepo;
    private final MarketPriceRepo marketPriceRepo;
    private  final ModelMapper modelMapper;

    @Override
    public MarketPricedto addMarketPrice(AddMarketPricedto price){

        MarketPrice marketPrice = modelMapper.map(price,MarketPrice.class);
        MarketPrice saveprice = marketPriceRepo.save(marketPrice);
        MarketPricedto pricedto = modelMapper.map(saveprice,MarketPricedto.class);
        return pricedto;
    }




    @Override
    public List<MarketPrice> getTodayPrice(String veg){
        return marketPriceRepo.findByvegetableName_VegNameAndPriceDate(veg, LocalDate.now());
    }

    @Override
    public List<MarketPrice> getByplace(String place){
        return marketPriceRepo.findByMarketPlace(place);
    }

    @Override
    public VegetableDto addVegetables(AddVegetabledto addVegetable) {
        Vegetable newVeg = modelMapper.map(addVegetable, Vegetable.class);
        Vegetable saveVeg = vegtableRepo.save(newVeg);
        return modelMapper.map(saveVeg, VegetableDto.class);
    }

    @Override
    public List<VegtablePriceDto> getAllVeg_prices(){
        List<Vegetable> vegtable = vegtableRepo.findAll();

        return vegtable.stream().map(veg->{
            Double Price = veg.getPrices()
                    .stream()
                    .sorted((a,b)->b.getPriceDate().compareTo(a.getPriceDate()))
                    .findFirst()
                    .map(MarketPrice::getPrice)
                    .orElse(null);

            return new VegtablePriceDto(
                    veg.getVegName(),
                    veg.getImage_url(),
                    Price
            );

        }).toList();
    }

}
