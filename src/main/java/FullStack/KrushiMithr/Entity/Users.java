package FullStack.KrushiMithr.Entity;

//import FullStack.KrushiMithr.Entity.type.Role;
import FullStack.KrushiMithr.Entity.type.AuthType;
import FullStack.KrushiMithr.Entity.type.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Farmers_app_users",indexes = {
        @Index(name = "idx_providerId_providerType",columnList = "providerId,providerType")
})
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;
//    private String email;
    private String password;

    @OneToOne(mappedBy = "users")
    private Farmer farmer;

    @OneToOne(mappedBy = "users")
    private Buyers buyers;
    @Enumerated(EnumType.STRING)
    private Role role;

    private String providerId;
    @Enumerated(EnumType.STRING)
    private AuthType providerType;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return userName;
    }

}

