package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepo extends JpaRepository<Buyers, Long> {
    Optional<Buyers> findByUsersId(Long userId);
}
