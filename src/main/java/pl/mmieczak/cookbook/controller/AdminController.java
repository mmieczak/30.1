package pl.mmieczak.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/admin/receipts")
    String adminReceipts(Model model, ReceiptFilters receiptFilters) {

        /*ReceiptController receiptController = new ReceiptController(receiptService, categoryService, authorService);
        receiptController.showReceipts(model, receiptFilters);*/

        List<Receipt> allUsersReceipts;

        if (receiptFilters.getCategory() == null) {
            receiptFilters.setCategory(new Category());
        }

        if (receiptFilters.getCategory().equals(new Category()))
            allUsersReceipts = receiptService.findAllForEmptyCategory(receiptFilters);
        else {
            allUsersReceipts = receiptService.findAllforFilters(receiptFilters);
        }

        String messageAdminAfterUpdateLikes = String.valueOf(model.asMap().get("message"));

        model.addAttribute("allcategories", categoryService.findAllCategories());
        model.addAttribute("allauthors", authorService.findAllAuthors());
        model.addAttribute("receipts", allUsersReceipts);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("filters", receiptFilters);
        model.addAttribute("message", messageAdminAfterUpdateLikes);
        return "admin-rec";
    }

    @PostMapping("/vote-admin")
    String vote(Receipt receipt) {
        receipt.setVotes(receipt.getVotes() + 1);
        receiptService.save(receipt);
        return "redirect:/admin/receipts";
    }
}
