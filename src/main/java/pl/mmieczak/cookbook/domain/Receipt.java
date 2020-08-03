package pl.mmieczak.cookbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Receipt")
@Table(name = "receipt")
@Getter
@Setter
@NoArgsConstructor
//@ToString


public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer votes;

    @Lob
    private byte[] imgData;

    @Autowired
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})

    private Author author;

    @Autowired
    @ManyToMany
    private List<Category> categories;

    @OneToMany(mappedBy = "receipt", orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        ingredient.setReceipt(this);
    }


    public Receipt(Long id, String name, Integer votes, byte[] imgData, Author author, List<Category> categories, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.votes = votes;
        this.imgData = imgData;
        this.author = author;
        this.categories = categories;
        this.ingredients = ingredients;
    }


}
