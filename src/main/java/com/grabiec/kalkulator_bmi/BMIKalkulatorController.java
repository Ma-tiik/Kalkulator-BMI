package com.grabiec.kalkulator_bmi;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.ui.Model;

//zmiana zmiana 

@Controller
public class BMIKalkulatorController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/wynik.html").setViewName("wynik.html");
    }

    @GetMapping("/")
    public String showKalkulatorBMI(KalkulatorBMI kalkulatorBMI) {
        return "index";
    }

    @PostMapping("/")
    public String obliczBMI(@Valid KalkulatorBMI kalkulatorBMI, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        double bmi = kalkulatorBMI.obliczBMI();
        model.addAttribute("bmi", bmi);
        model.addAttribute("waga", kalkulatorBMI.getWaga());
        model.addAttribute("wzrost", kalkulatorBMI.getWzrost());

        String processedData = "Przetworzone dane: Waga=" + kalkulatorBMI.getWaga() + ", Wzrost=" + kalkulatorBMI.getWzrost();
        model.addAttribute("processedData", processedData);

        return "wynik";
    }
}
