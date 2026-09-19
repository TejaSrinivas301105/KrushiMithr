package FullStack.KrushiMithr.Exception;

public class FarmerNotFoundException extends RuntimeException {
    public FarmerNotFoundException(Long id) {
        super("Farmer not found with id: " + id);
    }
}
