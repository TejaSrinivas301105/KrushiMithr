package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.AddFarmerdto;
import FullStack.KrushiMithr.Dto.Farmersdto;
import FullStack.KrushiMithr.Entity.Farmer;
import FullStack.KrushiMithr.Exception.FarmerNotFoundException;
import FullStack.KrushiMithr.Repository.FarmersRepo;
import FullStack.KrushiMithr.Services.ServiceImple;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmerService implements ServiceImple {

    private final FarmersRepo farmersRepo;
    private final ModelMapper modelMapper;

    @Override
    public Farmersdto createFarmers(AddFarmerdto dto) {
        Farmer farmer = modelMapper.map(dto, Farmer.class);
        return modelMapper.map(farmersRepo.save(farmer), Farmersdto.class);
    }

    @Override
    public List<Farmersdto> getALlFarmers() {
        return farmersRepo.findAll().stream()
                .map(f -> modelMapper.map(f, Farmersdto.class))
                .toList();
    }

    @Override
    public Farmersdto getFarmerById(Long id) {
        Farmer farmer = farmersRepo.findById(id)
                .orElseThrow(() -> new FarmerNotFoundException(id));
        return modelMapper.map(farmer, Farmersdto.class);
    }
}
