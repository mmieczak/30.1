package pl.mmieczak.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mmieczak.cookbook.domain.Author;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Ingredient;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.service.AuthorService;
import pl.mmieczak.cookbook.service.CategoryService;
import pl.mmieczak.cookbook.service.ReceiptService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class ReceiptController {

    private final ReceiptService receiptService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private static final Integer INGREDIENTS_AMOUNT = 3;

    @Autowired
    public ReceiptController(ReceiptService receiptService, CategoryService categoryService, AuthorService authorService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
        this.authorService = authorService;

    }

    @GetMapping("/create")
    String createReceipt(Receipt receipt, Model model) {
        initializeCategories(receipt);
        initializeAuthor(receipt);
        initializeIngriedients(receipt, INGREDIENTS_AMOUNT);
        model.addAttribute("receipt", receipt);
        return "create";
    }


    private void initializeCategories(Receipt receipt) {
        List<Category> allCategories = categoryService.findAllCategories();
        receipt.setCategories(allCategories);
        receiptService.save(receipt);
    }

    private void initializeIngriedients(Receipt receipt, Integer ingredientsAmount) {
        for (int i = 1; i <= ingredientsAmount; i++) {
            Ingredient ingredient = new Ingredient();
            receipt.addIngredient(ingredient);
            receiptService.saveNewIngredient(ingredient);
        }
    }

    private void initializeAuthor(Receipt receipt) {
        Author author = new Author();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = "";
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        Optional<Author> loginExist = authorService.findLoginExist(userName);
        if (loginExist.isPresent()) {
            author = loginExist.get();
        } else {
            author.setFirstname(userName);
        }
        receipt.setAuthor(author);
    }

    @PostMapping("/create")
    String addReceipt(Receipt receipt, BindingResult bindingResult, HttpServletRequest request, Model model) throws IOException, ServletException {

        receipt.getIngredients().forEach(ingredient -> ingredient.setReceipt(receipt));
        receipt.getAuthor().addReceipt(receipt);


        //receipt.getCategories().forEach(category -> category.getReceipts().set(0,receipt));

        receipt.setVotes(0);
        //Receipt IMAGE ADD
        final Part filePart = request.getPart("image_uploads");
        byte[] receiptImage = filePart.getInputStream().readAllBytes();
        receipt.setReceiptImage(receiptImage);


        receiptService.save(receipt);
        //model.addAttribute("receipt", receipt);

        return "redirect:/";
    }

}
