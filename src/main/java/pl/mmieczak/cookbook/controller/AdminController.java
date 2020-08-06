package pl.mmieczak.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.domain.ReceiptFilters;
import pl.mmieczak.cookbook.service.CategoryService;
import pl.mmieczak.cookbook.service.ReceiptService;
import pl.mmieczak.cookbook.util.ImageUtil;

import java.util.List;

@Controller
public class AdminController {

    ReceiptService receiptService;
    CategoryService categoryService;

    public AdminController(ReceiptService receiptService, CategoryService categoryService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin")
    @ResponseBody
    String home() {
        return "Jesteś w panelu administratora";
    }

    @GetMapping("/admin/receipts")
    String adminReceipts(Model model, @RequestParam(required = false) String sort,
                         ReceiptFilters receiptFilters) {

        List<Receipt> allReceipts;

        if (sort != null) {
            allReceipts = receiptService.findAllSorted(sort);
        } else {
            if (receiptFilters.getCategory() != "") {
                Category category = categoryService.findAllByNameContaining(receiptFilters.getCategory());
                allReceipts = receiptService.findAllforFilters(receiptFilters, category);
            } else
                allReceipts = receiptService.findAllforEmptyFilters(receiptFilters);

        }
        model.addAttribute("receipts", allReceipts);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("filters", receiptFilters);

        return "admin-rec";
    }

   /* (Model model,
    ) {
        List<Auction> auctions;

            auctions = auctionService.findAllSorted(sort);
        } else {
            auctions = auctionService.findAllForFilters(auctionFilters);
        }

        model.addAttribute("cars", auctions);
        model.addAttribute("filters", auctionFilters);
        return "auctions";*/

}
