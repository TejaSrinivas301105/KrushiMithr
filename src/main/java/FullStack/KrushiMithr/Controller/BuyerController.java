package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.AddBuyerDto;
import FullStack.KrushiMithr.Dto.BuyerDto;
import FullStack.KrushiMithr.Services.BuyerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping("/register/{userId}")
    public ResponseEntity<BuyerDto> registerBuyer(
            @PathVariable Long userId,
            @RequestBody @Valid AddBuyerDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(buyerService.registerBuyer(userId, dto));
    }

    @GetMapping("/{buyerId}")
    public ResponseEntity<BuyerDto> getBuyerById(@PathVariable Long buyerId) {
        return ResponseEntity.ok(buyerService.getBuyerById(buyerId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<BuyerDto> getBuyerByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(buyerService.getBuyerByUserId(userId));
    }
}
