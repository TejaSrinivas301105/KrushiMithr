package FullStack.KrushiMithr.Config;

import FullStack.KrushiMithr.Dto.*;
import FullStack.KrushiMithr.Entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // CropListing -> CropListingDto: vegetable.vegName -> vegetableName
        mapper.typeMap(CropListing.class, CropListingDto.class).addMappings(m ->
                m.map(src -> src.getVegetable().getVegName(), CropListingDto::setVegetableName)
        );

        // FarmerCrop -> FarmerCropDto: farmer.farmerName, vegetable.vegName
        mapper.typeMap(FarmerCrop.class, FarmerCropDto.class).addMappings(m -> {
            m.map(src -> src.getFarmer().getFarmerName(), FarmerCropDto::setFarmerName);
            m.map(src -> src.getVegetable().getVegName(), FarmerCropDto::setVegetableName);
        });

        // Buyers -> BuyerDto: users.username -> userName
        mapper.typeMap(Buyers.class, BuyerDto.class).addMappings(m ->
                m.map(src -> src.getUsers().getUsername(), BuyerDto::setUserName)
        );

        // MarketPrice -> MarketPricedto: vegetable.vegName -> vegetableName
        mapper.typeMap(MarketPrice.class, MarketPricedto.class).addMappings(m ->
                m.map(src -> src.getVegetable().getVegName(), MarketPricedto::setVegetableName)
        );

        // Farmer -> Farmersdto: listings mapped via CropListing -> CropListingDto typeMap
        mapper.typeMap(Farmer.class, Farmersdto.class);

        return mapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    UserDetailsService userDetailsService(){
        UserDetails user1 = User.withUsername("farmer")
                .password(passwordEncoder().encode("pass"))
                .roles("FARMER")
                .build();

        UserDetails user2 = User.withUsername("people")
                .password(passwordEncoder().encode("pass"))
                .roles("PEOPLE")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);

    }

}
