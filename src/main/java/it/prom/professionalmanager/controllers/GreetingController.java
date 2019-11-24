package it.prom.professionalmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для выдачи стартовой html страницы
 */
@Controller
@RequestMapping(value = "/it-prom")
public class GreetingController {

    @GetMapping
    String greeting() {
        return "index";
    }
}
