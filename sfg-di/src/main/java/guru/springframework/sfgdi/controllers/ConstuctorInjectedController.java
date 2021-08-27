package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

public class ConstuctorInjectedController {

    public ConstuctorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    private final GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
