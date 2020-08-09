package pl.mmieczak.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findAllByCategoryIdEquals(long categoryId) {
        return categoryRepository.findAllByIdEquals(categoryId);
    }
}
