package FullStack.KrushiMithr.Controller;

import FullStack.KrushiMithr.Dto.LoginRequestdto;
import FullStack.KrushiMithr.Dto.LoginResponedto;
import FullStack.KrushiMithr.Dto.SignupRequestdto;
import FullStack.KrushiMithr.Dto.SignupResponedto;
import FullStack.KrushiMithr.Services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponedto> login(@RequestBody LoginRequestdto loginRequestdto){
        return ResponseEntity.ok(authService.login(loginRequestdto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponedto> signup(@RequestBody SignupRequestdto signupRequestdto){
        return ResponseEntity.ok(authService.signup(signupRequestdto));
    }
}
