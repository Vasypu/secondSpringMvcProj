package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecodController {

    @GetMapping("/exit")
    public String exit(@RequestParam(value = "a") int a,
                       @RequestParam(value = "b") int b,
                       @RequestParam(value = "action", required = false) String action,
                       Model model) {
        int result;

        switch (action) {
            case "multiplication": result = a*b;
            break;
            case "addition": result = a+b;
            break;
            case "subtraction": result = a-b;
            break;
            case "division": result = a/b;
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }

        model.addAttribute("message", "result= " + result);
        return "second/exit";
    }
}
