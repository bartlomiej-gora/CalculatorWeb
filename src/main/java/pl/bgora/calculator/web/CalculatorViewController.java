package pl.bgora.calculator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorViewController {

    @RequestMapping("/calculator")
    String getHello(){
        return "calculator";
    }
}
