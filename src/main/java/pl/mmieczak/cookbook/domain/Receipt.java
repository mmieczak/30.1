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
//@ToString

public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer votes;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Author author;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "receipt", orphanRemoval = true)
    private List<Ingredient> ingredients;


}
