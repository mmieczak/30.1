package pl.mmieczak.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Ingredient;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.domain.ReceiptFilters;
import pl.mmieczak.cookbook.repository.CategoryRepository;
import pl.mmieczak.cookbook.repository.IngredientRepository;
import pl.mmieczak.cookbook.repository.ReceiptRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.Sort.by;

@Service
public class ReceiptService {

    ReceiptRepository receiptRepository;
    CategoryRepository categoryRepository;
    IngredientRepository ingredientRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository, CategoryRepository categoryRepository, IngredientRepository ingredientRepository) {
        this.receiptRepository = receiptRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    public List<Receipt> find3TopRated() {
        return receiptRepository.findTop3ByOrderByVotesDesc();
    }

    public List<Receipt> findAllSorted(String property) {
        Sort sortProperty = by(Sort.Order.by(property).ignoreCase().with(Direction.ASC));
        return receiptRepository.findAll(sortProperty);
    }

    public List<Receipt> findAllForFilters(ReceiptFilters receiptFilters) {
        return receiptRepository.findByNameContainsIgnoreCaseAndAuthor_UsernameContainsIgnoreCaseAndCategoriesContains(receiptFilters.getName(), receiptFilters.getAuthor(), receiptFilters.getCategory());
    }

    public Optional<Receipt> findAllForId(Long receiptId) {
        return receiptRepository.findById(receiptId);
    }

    public void saveNewIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public List<Receipt> findAllForEmptyCategory(ReceiptFilters receiptFilters) {
        return receiptRepository.findByNameContainingIgnoreCaseAndAuthor_UsernameContainsIgnoreCase(receiptFilters.getName(), receiptFilters.getAuthor());
    }

    public void deleteById(Long id) {
        receiptRepository.deleteById(id);
    }

    public List<Receipt> findAllForCategory(Category selectedCategory) {
        return receiptRepository.findAllByCategoriesContains(selectedCategory);
    }

    public List<Receipt> findAllForCategoryAndReceiptName(Category selectedCategory, String name) {
        return receiptRepository.findAllByCategoriesContainsAndNameContainingIgnoreCase(selectedCategory, name);
    }

    public void modifyReceipt(Receipt receiptWithNewValues) {
        Optional<Receipt> currentReceipt = receiptRepository.findAllById(receiptWithNewValues.getId());
        Receipt modifiedReceipt;

        if (currentReceipt.isPresent()) {
            modifiedReceipt = currentReceipt.get();
            modifiedReceipt.setName(receiptWithNewValues.getName());
            modifiedReceipt.setAuthor(receiptWithNewValues.getAuthor());
            modifiedReceipt.setReceiptImage(receiptWithNewValues.getReceiptImage());
            modifiedReceipt.setCategories(receiptWithNewValues.getCategories());
            modifiedReceipt.setVotes(receiptWithNewValues.getVotes());
            modifiedReceipt.setIngredients(receiptWithNewValues.getIngredients());
            receiptRepository.save(modifiedReceipt);
        }
    }
}
