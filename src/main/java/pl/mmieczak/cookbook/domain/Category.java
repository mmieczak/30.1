package pl.mmieczak.cookbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static Category create() {
        return new Category();
    }
}
