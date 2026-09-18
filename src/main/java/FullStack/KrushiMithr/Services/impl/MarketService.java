package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.*;
import FullStack.KrushiMithr.Entity.MarketPrice;
import FullStack.KrushiMithr.Entity.Vegetable;
import FullStack.KrushiMithr.Repository.MarketPriceRepo;
import FullStack.KrushiMithr.Repository.VegtableRepo;
import FullStack.KrushiMithr.Services.MarketPriceService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService implements MarketPriceService {

    private final VegtableRepo vegtableRepo;
    private final MarketPriceRepo marketPriceRepo;
    private final ModelMapper modelMapper;

    @Override
    public MarketPricedto addMarketPrice(AddMarketPricedto dto) {
        Vegetable vegetable = vegtableRepo.findById(dto.getVegetableId())
                .orElseThrow(() -> new IllegalArgumentException("Vegetable not found"));

        MarketPrice marketPrice = modelMapper.map(dto, MarketPrice.class);
        marketPrice.setVegetable(vegetable);

        return modelMapper.map(marketPriceRepo.save(marketPrice), MarketPricedto.class);
    }

    @Override
    public List<MarketPrice> getTodayPrice(String veg) {
        return marketPriceRepo.findByVegetable_VegNameAndPriceDate(veg, LocalDate.now());
    }

    @Override
    public List<MarketPrice> getByplace(String place) {
        return marketPriceRepo.findByMarketPlace(place);
    }

    @Override
    public VegetableDto addVegetables(AddVegetabledto dto) {
        Vegetable newVeg = modelMapper.map(dto, Vegetable.class);
        return modelMapper.map(vegtableRepo.save(newVeg), VegetableDto.class);
    }

    @Override
    public List<VegtablePriceDto> getAllVeg_prices() {
        return vegtableRepo.findAll().stream().map(veg -> {
            Double price = veg.getPrices().stream()
                    .sorted((a, b) -> b.getPriceDate().compareTo(a.getPriceDate()))
                    .findFirst()
                    .map(MarketPrice::getPrice)
                    .orElse(null);
            return new VegtablePriceDto(veg.getVegName(), veg.getImage_url(), price);
        }).toList();
    }
}
