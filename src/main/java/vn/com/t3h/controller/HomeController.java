package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
-danh dau cho spring biet day la tang controller va can duoc tao bean trong spring container
-tra ve giao dien html qua thu vien jsp
* */
@Controller
public class HomeController {
    /*
    @GetMapping: method get cua http
    @PostMapping: method post cua http
    @PutMapping: method Put http
    @DeleteMapping: method delete http

    /home: -> method nay se duoc xu ly request voi url localhost:8080/home
    */
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
