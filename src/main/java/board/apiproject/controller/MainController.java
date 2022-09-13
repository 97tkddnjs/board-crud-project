package board.apiproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class MainController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/")
    public String login() {

        return "index";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

}
