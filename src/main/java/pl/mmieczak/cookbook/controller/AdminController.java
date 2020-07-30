package pl.mmieczak.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @GetMapping("/admin")
    @ResponseBody
    String home() {
        return "Jesteś w panelu administratora";
    }
}
