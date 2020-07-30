package pl.mmieczak.cookbook.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceiptFilters {

    private String name = "";
    private String votes = "";
    private Author author = new Author();


}
