package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES","default"})
@Service("i18Service")
public class I18SpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola mundo - ES";
    }
}
