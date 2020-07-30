package pl.mmieczak.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mmieczak.cookbook.domain.Author;
import pl.mmieczak.cookbook.service.ReceiptService;

@Controller
public class RegistrationController {

    private ReceiptService userService;

    @Autowired
    public RegistrationController(ReceiptService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String main() {
        return "register";
    }

    @PostMapping("/register")
    String register(@RequestParam Author username, @RequestParam String password) {
        //userService.save(username, password);
        return "redirect:/login";
    }
}
