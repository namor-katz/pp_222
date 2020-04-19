package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class CarsController {

    @RequestMapping(value = "cars", method = RequestMethod.GET)
    public String tempHello() {
        System.out.println("я тестовый метод");
        return "hhh";
    }
}
