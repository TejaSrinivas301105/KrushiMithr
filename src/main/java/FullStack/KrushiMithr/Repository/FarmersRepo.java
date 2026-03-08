package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FarmersRepo extends JpaRepository<Farmer, Long> {
}
