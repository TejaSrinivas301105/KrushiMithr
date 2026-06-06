package FullStack.KrushiMithr.Services.impl;

import FullStack.KrushiMithr.Dto.LoginRequestdto;
import FullStack.KrushiMithr.Dto.LoginResponedto;
import FullStack.KrushiMithr.Dto.SignupRequestdto;
import FullStack.KrushiMithr.Dto.SignupResponedto;
import FullStack.KrushiMithr.Entity.Users;
import FullStack.KrushiMithr.Entity.type.AuthType;

import FullStack.KrushiMithr.Repository.UsersRepo;
import FullStack.KrushiMithr.Security.Authutil;
import FullStack.KrushiMithr.Services.AuthService;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AuthSevices implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsersRepo usersRepo;
    private final Authutil authutil;
    private final PasswordEncoder passwordEncoder;

    public AuthSevices(@Lazy AuthenticationManager authenticationManager,
                       UsersRepo usersRepo,
                       Authutil authutil,
                       PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usersRepo = usersRepo;
        this.authutil = authutil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponedto login(LoginRequestdto loginRequestdto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestdto.getUsername(),loginRequestdto.getPassword())
        );

        Users users = (Users) authentication.getPrincipal();

        String token = authutil.generatetoken(users);

        return new LoginResponedto(token, users.getId());
    }

    public Users signupInternal(SignupRequestdto signupRequestdto,AuthType authType,String providerId){
        Users user = usersRepo.findByUserName(signupRequestdto.getUsername()).orElse(null);

        if(user != null){
            throw new IllegalArgumentException("User already exists");
        }

         user = (Users.builder()
                .userName(signupRequestdto.getUsername())
                .providerId(providerId)
                 .providerType(authType)
                .role(signupRequestdto.getRole())
                .build()
        );

        if(authType == AuthType.EMAIL){
            user.setPassword(passwordEncoder.encode(signupRequestdto.getPassword()));
        }

        return usersRepo.save(user);
    }

    @Override
    public SignupResponedto signup(SignupRequestdto signupRequestdto){

        Users user = signupInternal(signupRequestdto,AuthType.EMAIL,null);

        return new SignupResponedto(user.getId(),user.getUsername(),user.getRole());

    }
    @Override
    public ResponseEntity<LoginResponedto> handleoAuthLoginRequest(OAuth2User user, String registrationid){
        AuthType providerType = authutil.getProviderTypeFromRegisrationId(registrationid);

        String providerId = authutil.determineProviderId(user,registrationid);

        Users users = usersRepo.findByProviderIdAndProviderType(providerId,providerType);
        String email = user.getAttribute("email");

        Users userEmail = usersRepo.findByUserName(email).orElse(null);

        if(users == null && userEmail == null){
            String userName = authutil.determineProviderId(user,registrationid,providerId);

            users = signupInternal(new SignupRequestdto(userName,null,null),providerType,providerId);
        } else if(users != null) {
            if( email != null && !email.isBlank() && !email.equals(users.getUsername())){
                users.setUserName(email);
                usersRepo.save(users);
            }
        }
        else{
            throw new BadCredentialsException("The user is already exist with provider"+email);
        }
        LoginResponedto loginResponedto = new LoginResponedto(authutil.generatetoken(users), users.getId());

        return ResponseEntity.ok(loginResponedto);
    }
}
