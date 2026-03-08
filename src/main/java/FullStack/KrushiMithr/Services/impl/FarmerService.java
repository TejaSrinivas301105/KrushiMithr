package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.AddFarmerdto;
import FullStack.KrushiMithr.Dto.Farmersdto;
import FullStack.KrushiMithr.Entity.Farmer;
import FullStack.KrushiMithr.Repository.FarmersRepo;
import FullStack.KrushiMithr.Repository.MarketPriceRepo;
import FullStack.KrushiMithr.Repository.VegtableRepo;
import FullStack.KrushiMithr.Services.ServiceImple;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class FarmerService implements ServiceImple {
    private final FarmersRepo farmersRepo;
    private  final ModelMapper modelMapper;
    private final MarketPriceRepo marketPriceRepo;
    private final VegtableRepo vegtableRepo;

//    @Transactional
//    public Farmersdto createFarmers(Farmersdto farmersdto) {
//        Farmer newfarmer = modelMapper.map(farmersdto,Farmer.class);
//        Farmer savedfarmer =  farmersRepo.save(newfarmer);
//        return modelMapper.map(savedfarmer,Farmersdto.class);
//    }




    @Override
    public List<Farmersdto> getALlFarmers(){
        List<Farmer> farmers = farmersRepo.findAll();
        return farmers.stream()
                .map((Farmer farmer)-> modelMapper.map(farmer, Farmersdto.class)).toList();

    }

    @Override
    public Farmersdto createFarmers(AddFarmerdto addFarmerdto){
        Farmer newfarmer = modelMapper.map(addFarmerdto,Farmer.class);
        Farmer savefarmer = farmersRepo.save(newfarmer);
        return modelMapper.map(savefarmer,Farmersdto.class);
    }

    @Override
    public Farmersdto getFarmerById(Long id){
        Farmer farmer = farmersRepo.findById(id).orElseThrow(()->new IllegalArgumentException("This is no farmer with that id"));
        return modelMapper.map(farmer, Farmersdto.class);
    }






}
