package pl.mmieczak.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmieczak.cookbook.domain.Author;
import pl.mmieczak.cookbook.domain.Receipt;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findTop3ByOrderByVotesDesc();

    //List<Receipt> findByNameContainsIgnoreCaseAndVotesContainsIgnoreCaseAndAuthorContainsIgnoreCase(String name, String votes, String author);
}
