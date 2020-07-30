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

    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST})
    private List<Receipt> receipts;

/*    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        receipt.setCategories(new ArrayList<Category>().add(this));
    }*/

/*    //Helper Method, zachowanie spojnosci modelu danych i modelu obiektowego
    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        List<Category> categories = new ArrayList<>();
        categories.add(this);
        receipt.setCategories(categories);
    }*/
}
