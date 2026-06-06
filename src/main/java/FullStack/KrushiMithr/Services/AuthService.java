package FullStack.KrushiMithr.Services;

import FullStack.KrushiMithr.Dto.LoginRequestdto;
import FullStack.KrushiMithr.Dto.LoginResponedto;
import FullStack.KrushiMithr.Dto.SignupRequestdto;
import FullStack.KrushiMithr.Dto.SignupResponedto;
import FullStack.KrushiMithr.Entity.Users;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;


public interface AuthService {
    public LoginResponedto login(LoginRequestdto loginRequestdto);
    public SignupResponedto signup(SignupRequestdto signupRequestdto);



    public ResponseEntity<LoginResponedto> handleoAuthLoginRequest(OAuth2User user, String registrationid);
}
