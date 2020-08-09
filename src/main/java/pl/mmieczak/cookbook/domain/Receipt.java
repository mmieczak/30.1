package pl.mmieczak.cookbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Receipt")
@Getter
@Setter
@NoArgsConstructor

public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer votes;

    @Lob
    private byte[] receiptImage;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Category> categories;

    @OneToMany(mappedBy = "receipt", cascade = {CascadeType.ALL})
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setReceipt(this);
    }

    public Receipt(Long id, String name, Integer votes, byte[] receiptImage, Author author, List<Category> categories, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.votes = votes;
        this.receiptImage = receiptImage;
        this.author = author;
        this.categories = categories;
        this.ingredients = ingredients;
    }
}
