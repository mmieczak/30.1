package pl.mmieczak.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mmieczak.cookbook.domain.Ingredient;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.repository.CategoryRepository;
import pl.mmieczak.cookbook.repository.IngredientRepository;
import pl.mmieczak.cookbook.repository.ReceiptRepository;

import java.util.List;

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

    public void saveNewIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }


    //zrobic uzywajac specyfikacji!!!!
  /*  public List<Receipt> findAllForFilters(ReceiptFilters receiptFilters) {
        //   Specification
        return receiptRepository.findByNameContainsIgnoreCaseAndVotesContainsIgnoreCaseAndAuthorContainsIgnoreCase(receiptFilters.getName(), receiptFilters.getVotes(), receiptFilters.getAuthor().getSurname());
    }*/
}
