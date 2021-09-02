package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public class PropertyInjectedGreetingService implements GreetingService {


    @Override
    public String sayGreeting() {
        return "Hello world! - Property";
    }
}
