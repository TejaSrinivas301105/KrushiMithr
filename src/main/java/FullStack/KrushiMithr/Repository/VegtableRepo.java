package FullStack.KrushiMithr.Repository;

import FullStack.KrushiMithr.Entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VegtableRepo extends JpaRepository<Vegetable,Long> {
    public List<Vegetable> findByVegName(String VegName);
}
