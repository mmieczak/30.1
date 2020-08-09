package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findTop3ByOrderByVotesDesc();

    List<Receipt> findByNameContainsIgnoreCaseAndAuthor_UsernameContainsIgnoreCaseAndCategoriesContains(String name, String author, Category category);

    Optional<Receipt> findAllById(Long id);

    List<Receipt> findByNameContainingIgnoreCaseAndAuthor_UsernameContainsIgnoreCase(String name, String author);

    List<Receipt> findAllByCategoriesContains(Category category);

    List<Receipt> findAllByCategoriesContainsAndNameContainingIgnoreCase(Category category, String receiptName);
}
