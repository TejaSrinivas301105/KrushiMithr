package FullStack.KrushiMithr.Exception;

public class BuyerNotFoundException extends RuntimeException {
    public BuyerNotFoundException(Long id) {
        super("Buyer not found with id: " + id);
    }
}
