package pl.mmieczak.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mmieczak.cookbook.domain.Author;
import pl.mmieczak.cookbook.domain.Category;
import pl.mmieczak.cookbook.domain.Receipt;
import pl.mmieczak.cookbook.service.ReceiptService;

import java.util.List;

@Controller
public class CookBookController {

    ReceiptService receiptService;

    @Autowired
    public CookBookController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping("/")
    @ResponseBody
    String showAll(Model model) {
        List<Receipt> receipts = receiptService.findAllSorted("votes");
        //model.addAttribute("tasks", taskList);
        // model.addAttribute("task", new Task());
        return receipts.toString();
    }

    @GetMapping("/save")
    String save(Model model) {
        Author author = new Author();
        author.setName("NEW NAME");
        author.setSurname("NEW Surname");

        Category category = new Category();
        category.setName("NEW CATEGORY");

        receiptService.save(author, "NEW RECEIPT", category);


        //model.addAttribute("tasks", taskList);
        // model.addAttribute("task", new Task());
        return "redirect:/";
    }

/*    @GetMapping("/sorted")
    @ResponseBody
    String showSorted(Model model) {
        List<Receipt> receipts = receiptService.findAllSorted("author");
        //model.addAttribute("tasks", taskList);
        // model.addAttribute("task", new Task());
        return receipts.toString();
    }*/
}
