package pl.mmieczak.cookbook.controller;

import org.springframework.stereotype.Controller;

@Controller
public class CookBookController {

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
