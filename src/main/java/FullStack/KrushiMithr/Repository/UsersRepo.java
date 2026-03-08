package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Long> {
}
