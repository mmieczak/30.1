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
import pl.mmieczak.cookbook.util.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@Controller
public class ReceiptController {

    private final ReceiptService receiptService;
    private final CategoryService categoryService;

    @Autowired
    public ReceiptController(ReceiptService receiptService, CategoryService categoryService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    String showMainPage(Model model) {
        List<Receipt> receipts = receiptService.find3TopRated();
        model.addAttribute("toprated", receipts);
        model.addAttribute("imgUtil", new ImageUtil());
        return "index";
    }


    @GetMapping("/create")
    String createReceipt(Receipt rec, Model model) {

        //GATHER Categories
        rec.setCategories(categoryService.findAllCategories());


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
        rec.setAuthor(author);

        //GENERATE INPUT form for INGREDIENTS
        for (int i = 1; i <= 5; i++) {
            rec.addIngredient(new Ingredient());
        }

        model.addAttribute("receipt", rec);
        return "create";
    }

    @PostMapping("/create")
    String addReceipt(Receipt receipt, BindingResult bindingResult, HttpServletRequest request, Model model) throws IOException, ServletException {

        //IMAGE ADD
        final Part filePart = request.getPart("image_uploads");
        byte[] receiptImage = filePart.getInputStream().readAllBytes();
        receipt.setImgData(receiptImage);

        // receipt.addIngredient(ingredient);

        model.addAttribute("receipt", receipt);
        receiptService.save(receipt);

        return "create";
    }

}
