package pl.mmieczak.cookbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    private byte[] categoryImage;

    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Receipt> receipts = new ArrayList<>();

 /*   public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        receipt.setCategories(this);
    }*/

/*    //Helper Method, zachowanie spojnosci modelu danych i modelu obiektowego
    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        List<Category> categories = new ArrayList<>();
        categories.add(this);
        receipt.setCategories(categories);
    }*/
}
