package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.Users;
import FullStack.KrushiMithr.Entity.type.AuthType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String name);

    Users findByProviderIdAndProviderType(String providerId, AuthType providerType);
}
