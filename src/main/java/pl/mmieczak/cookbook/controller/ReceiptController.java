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
import pl.mmieczak.cookbook.domain.Ingredient;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.service.CategoryService;
import pl.mmieczak.cookbook.service.ReceiptService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

@Controller
public class ReceiptController {

    private final ReceiptService receiptService;
    private final CategoryService categoryService;

    @Autowired
    public ReceiptController(ReceiptService receiptService, CategoryService categoryService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    String createReceipt(Receipt receipt, Model model) {

        //GATHER Categories
        receipt.setCategories(categoryService.findAllCategories());

        //SET AUTHOR
        Author author = new Author();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = "";
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        author.setName(userName);
        receipt.setAuthor(author);

        //GENERATE INPUT form for INGREDIENTS
        for (int i = 1; i <= 3; i++) {
            Ingredient ingredient = new Ingredient();
            receipt.addIngredient(ingredient);
            receiptService.saveNewIngredient(ingredient);
        }


        model.addAttribute("receipt", receipt);

        return "create";
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
