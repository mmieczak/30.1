package pl.mmieczak.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mmieczak.cookbook.domain.Author;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.domain.ReceiptFilters;
import pl.mmieczak.cookbook.repository.CategoryRepository;
import pl.mmieczak.cookbook.repository.ReceiptRepository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.by;

@Service
public class ReceiptService {

    ReceiptRepository receiptRepository;
    CategoryRepository categoryRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository, CategoryRepository categoryRepository) {
        this.receiptRepository = receiptRepository;
        this.categoryRepository = categoryRepository;
    }

    public void save(Author author, String name, Category category) {

        List<Category> categories = new ArrayList<>();
        categories.add(category);

        Receipt receipt = new Receipt();

        receipt.setAuthor(author);
        receipt.setName(name);
        receipt.setVotes(/*Integer.toString(0)*/0);


        receipt.setCategories(categories);

        categoryRepository.save(category);
        receiptRepository.save(receipt);
    }

    public List<Receipt> find3TopRated() {
        return receiptRepository.findTop3ByOrderByVotesDesc();
    }


    public List<Receipt> findAllSorted(String property) {
        Sort sortProperty = by(Sort.Order.by(property).ignoreCase().with(Direction.ASC));
        return receiptRepository.findAll(sortProperty);
    }


    //zrobic uzywajac specyfikacji!!!!
  /*  public List<Receipt> findAllForFilters(ReceiptFilters receiptFilters) {
        //   Specification
        return receiptRepository.findByNameContainsIgnoreCaseAndVotesContainsIgnoreCaseAndAuthorContainsIgnoreCase(receiptFilters.getName(), receiptFilters.getVotes(), receiptFilters.getAuthor().getSurname());
    }*/
}
