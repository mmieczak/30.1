package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findTop3ByOrderByVotesDesc();


    List<Receipt> findByNameContainsIgnoreCaseAndAuthor_UsernameContainsIgnoreCaseAndCategoriesContains(String name, String author, Category category);

   /* List<Receipt> findByCategories
            (String name, String author, Category category);*/

    List<Receipt> findByNameContainingIgnoreCaseAndAuthor_UsernameContainsIgnoreCase(String name, String author);
}
