package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.AddBuyerDto;
import FullStack.KrushiMithr.Dto.BuyerDto;
import FullStack.KrushiMithr.Entity.Buyers;
import FullStack.KrushiMithr.Entity.Users;
import FullStack.KrushiMithr.Repository.BuyerRepo;
import FullStack.KrushiMithr.Repository.UsersRepo;
import FullStack.KrushiMithr.Services.BuyerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepo buyerRepo;
    private final UsersRepo usersRepo;
    private final ModelMapper modelMapper;

    @Override
    public BuyerDto registerBuyer(Long userId, AddBuyerDto dto) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (buyerRepo.findByUsersId(userId).isPresent()) {
            throw new IllegalArgumentException("Buyer profile already exists for this user");
        }

        Buyers buyer = modelMapper.map(dto, Buyers.class);
        buyer.setUsers(user);

        return modelMapper.map(buyerRepo.save(buyer), BuyerDto.class);
    }

    @Override
    public BuyerDto getBuyerByUserId(Long userId) {
        Buyers buyer = buyerRepo.findByUsersId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Buyer not found"));
        return modelMapper.map(buyer, BuyerDto.class);
    }

    @Override
    public BuyerDto getBuyerById(Long buyerId) {
        Buyers buyer = buyerRepo.findById(buyerId)
                .orElseThrow(() -> new IllegalArgumentException("Buyer not found"));
        return modelMapper.map(buyer, BuyerDto.class);
    }
}
