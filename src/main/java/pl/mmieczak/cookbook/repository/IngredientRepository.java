package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
