package FullStack.KrushiMithr.Services;
import java.util.*;

import FullStack.KrushiMithr.Dto.AddFarmerdto;
import FullStack.KrushiMithr.Dto.AddVegetabledto;
import FullStack.KrushiMithr.Dto.Farmersdto;
import FullStack.KrushiMithr.Dto.VegetableDto;

public interface ServiceImple {
    public Farmersdto createFarmers(AddFarmerdto addFarmerdto);
    public List<Farmersdto> getALlFarmers();
    public Farmersdto getFarmerById(Long id);

}
