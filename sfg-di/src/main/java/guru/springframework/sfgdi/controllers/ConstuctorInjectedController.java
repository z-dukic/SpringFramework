package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstuctorInjectedController {

    //@Autowired //Autowired nije potreban kod konstruktora
    //Bez @Qualifeier Spring neće znati koji bean treba koristit i koristit će primary bean
    public ConstuctorInjectedController(@Qualifier("constructorGreetingService")GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    private final GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
