package FullStack.KrushiMithr.Services;

import FullStack.KrushiMithr.Dto.AddBuyerDto;
import FullStack.KrushiMithr.Dto.BuyerDto;

public interface BuyerService {
    BuyerDto registerBuyer(Long userId, AddBuyerDto dto);
    BuyerDto getBuyerByUserId(Long userId);
    BuyerDto getBuyerById(Long buyerId);
}
