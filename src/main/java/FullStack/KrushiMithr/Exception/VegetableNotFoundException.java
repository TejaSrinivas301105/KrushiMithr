package FullStack.KrushiMithr.Exception;

public class VegetableNotFoundException extends RuntimeException {
    public VegetableNotFoundException(Long id) {
        super("Vegetable not found with id: " + id);
    }
}
