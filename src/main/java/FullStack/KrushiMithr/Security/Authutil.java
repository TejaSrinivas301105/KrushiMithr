package FullStack.KrushiMithr.Security;

import FullStack.KrushiMithr.Entity.Users;
import FullStack.KrushiMithr.Entity.type.AuthType;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@Slf4j
public class Authutil {

    @Value("${jwt.secretKey}")
    private String JwtSecretkey;


    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(JwtSecretkey.getBytes(StandardCharsets.UTF_8));
    }

    public String generatetoken(Users users){
        return Jwts.builder()
                .subject(users.getUsername())
                .claim("Userid",users.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10))
                .signWith(getSecretKey())
                .compact();

    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

    public AuthType getProviderTypeFromRegisrationId(String RegistrationId){
        return switch(RegistrationId.toLowerCase()){
            case "google" ->
                AuthType.Google;
            case "github" ->
                AuthType.Github;
            case "facebook" ->
                AuthType.Facebook;


            default -> throw new IllegalStateException("Unexpected value: " + RegistrationId.toLowerCase());
        };
    }

    public String determineProviderId(OAuth2User oAuth2User, String RegistrationId){
        String ProviderId = switch(RegistrationId.toLowerCase()){
            case "google" -> oAuth2User.getAttribute("sub");
            case "github" -> oAuth2User.getAttribute("login");

            default -> throw new IllegalStateException("Unexpected value: " + RegistrationId.toLowerCase());
        };

        if (ProviderId == null || ProviderId.isBlank()) {
            log.error("Unable to provide the Id {}",RegistrationId);
            throw new IllegalArgumentException("unable to determine the provider id for oAuth login ");
        }

        return ProviderId;

    }

    public String determineProviderId(OAuth2User oAuth2User, String RegistrationId, String providerId){

        String email = oAuth2User.getAttribute("email");
        if(email != null && !email.isBlank()){
            return email;
        }

        return  switch(RegistrationId.toLowerCase()){
            case "google" -> oAuth2User.getAttribute("sub");
            case "github" -> oAuth2User.getAttribute("login");

            default -> providerId;
        };

    }
}
