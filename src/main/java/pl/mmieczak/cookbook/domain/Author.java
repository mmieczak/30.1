package pl.mmieczak.cookbook.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String firstname;
    private String surname;

    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Receipt> receipts = new ArrayList<>();

    //Helper Method, zachowanie spojnosci modelu danych i modelu obiektowego
    public void addReceipt(Receipt receipt) {
        receipts.add(receipt);
        receipt.setAuthor(this);
    }

    public void removeReceipt(Receipt receipt) {
        receipts.remove(receipt);
        receipt.setAuthor(null);
    }

}

