package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.MarketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.*;


public interface MarketPriceRepo extends JpaRepository<MarketPrice,Long> {
    public List<MarketPrice> findByMarketPlace(String marketplace);
    public List<MarketPrice> findByvegetableName_VegNameAndPriceDate(String vegName, LocalDate date);
    
}
