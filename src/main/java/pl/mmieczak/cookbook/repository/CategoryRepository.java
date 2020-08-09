package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findAllByIdContaining(String name);

    Category findAllByIdEquals(long categoryId);
}

