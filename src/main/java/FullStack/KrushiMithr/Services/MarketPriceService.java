package FullStack.KrushiMithr.Services;

import FullStack.KrushiMithr.Dto.*;
import FullStack.KrushiMithr.Entity.MarketPrice;


import java.util.List;
import java.util.stream.Stream;

public interface MarketPriceService {
    public MarketPricedto addMarketPrice(AddMarketPricedto price);
    public List<MarketPrice> getTodayPrice(String veg);
    public List<MarketPrice> getByplace(String place);
    public VegetableDto addVegetables(AddVegetabledto addVegetable);
    public List<VegtablePriceDto> getAllVeg_prices();

}


