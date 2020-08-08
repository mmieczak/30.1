package pl.mmieczak.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.domain.ReceiptFilters;
import pl.mmieczak.cookbook.service.AuthorService;
import pl.mmieczak.cookbook.service.CategoryService;
import pl.mmieczak.cookbook.service.ReceiptService;
import pl.mmieczak.cookbook.util.ImageUtil;

import java.util.List;

@Controller
public class AdminController {

    ReceiptService receiptService;
    CategoryService categoryService;
    AuthorService authorService;

    public AdminController(ReceiptService receiptService, CategoryService categoryService, AuthorService authorService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/admin")
    @ResponseBody
    String home() {
        return "Jesteś w panelu administratora";
    }

    @GetMapping("/admin/receipts")
    String adminReceipts(Model model, ReceiptFilters receiptFilters) {

        List<Receipt> allReceipts;

        if (receiptFilters.getCategory() == null) {
            receiptFilters.setCategory(new Category());
        }

        if (receiptFilters.getCategory().equals(new Category()))
            allReceipts = receiptService.findAllForEmptyCategory(receiptFilters);
        else {
            allReceipts = receiptService.findAllforFilters(receiptFilters);
        }

        model.addAttribute("allcategories", categoryService.findAllCategories());
        model.addAttribute("allauthors", authorService.findAllAuthors());
        model.addAttribute("receipts", allReceipts);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("filters", receiptFilters);
        return "admin-rec";
    }

    @PostMapping("/vote-admin")
    String vote(Receipt receipt) {
        receipt.setVotes(receipt.getVotes() + 1);
        receiptService.save(receipt);
        return "redirect:/admin/receipts";
    }
}
