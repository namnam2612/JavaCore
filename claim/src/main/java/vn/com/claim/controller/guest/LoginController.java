package vn.com.claim.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login() {
        return "guest/loginmetlife";
    }

    @GetMapping("/dang-nhap")
    public String redirectToDashboard() {
        return "redirect:http://localhost:8081/cms/dashboard";
    }
}