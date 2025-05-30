package vn.com.claim.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/home","/"})
    public String home() {
        return "guest/home";
    }

    @GetMapping("/tai-khoan")
    public String redirectToLogin() {
        return "redirect:http://localhost:8081/login";
    }
}