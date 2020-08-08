package pl.mmieczak.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.service.CategoryService;
import pl.mmieczak.cookbook.service.ReceiptService;
import pl.mmieczak.cookbook.util.ImageUtil;

import java.io.IOException;
import java.util.List;

@Controller
public class CookBookController {

    private final ReceiptService receiptService;
    private final CategoryService categoryService;

    @Autowired
    public CookBookController(ReceiptService receiptService, CategoryService categoryService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    String showMainPage(Model model) throws IOException {
        List<Receipt> topRatedThreeReceipts = receiptService.find3TopRated();
        List<Category> allCategories = categoryService.findAllCategories();
        model.addAttribute("toprated", topRatedThreeReceipts);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("categories", allCategories);
/*

        byte[] imageAsBytes = ImageUtil.getImageAsBytes("test");
        model.addAttribute("imagedata", imageAsBytes);*/

        return "index";
    }



 /*   ReceiptService receiptService;
    CategoryService categoryService;

    @Autowired
    public CookBookController(ReceiptService receiptService, CategoryService categoryService) {
        this.receiptService = receiptService;
        this.categoryService = categoryService;
    }*/


   /* @GetMapping("/")
    String showMainPage(Model model) {
        List<Receipt> receipts = receiptService.find3TopRated();
        model.addAttribute("toprated", receipts);
        return "index";
    }

    @GetMapping("/index")
    String showMainPageas(Model model) {
        List<Receipt> receipts = receiptService.findAllSorted("votes");
        return "index";
    }*/

}
