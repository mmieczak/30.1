package pl.mmieczak.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.domain.ReceiptFilters;
import pl.mmieczak.cookbook.service.CategoryService;
import pl.mmieczak.cookbook.service.ReceiptService;
import pl.mmieczak.cookbook.util.ImageUtil;

import java.util.List;

@Controller
public class CategoryController {

    private final ReceiptService receiptService;
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(ReceiptService receiptService, CategoryService categoryService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    String showReceiptsForCategory(Model model, ReceiptFilters receiptFilters, @RequestParam Long id) {
        List<Receipt> allUsersReceipts;

        Category selectedCategory = categoryService.findAllByCategoryId(id);
        receiptFilters.setCategory(selectedCategory);
        if ("".equals(receiptFilters.getName()))
            allUsersReceipts = receiptService.findAllForCategory(selectedCategory);
        else
            allUsersReceipts = receiptService.findAllForCategoryAndReceiptName(selectedCategory, receiptFilters.getName());

        model.addAttribute("user-category", selectedCategory);
        model.addAttribute("receipts", allUsersReceipts);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("filters", receiptFilters);
        return "category";
    }
}

