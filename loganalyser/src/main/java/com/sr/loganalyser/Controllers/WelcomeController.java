package com.sr.loganalyser.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(@RequestParam(value = "name", defaultValue = "Mr No.Name") final String name,  final Model model) {
        model.addAttribute("message", this.message);
        model.addAttribute("name", name );
        return "welcome";
    }

}