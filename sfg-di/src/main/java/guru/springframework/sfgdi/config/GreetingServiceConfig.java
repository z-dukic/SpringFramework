package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}")String username,
                                  @Value("${guru.password}")String password,
                                  @Value("${guru.jdbcurl}")String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
            return fakeDataSource;
        }

        @Bean
        PetServiceFactory petServiceFactory () {
            return new PetServiceFactory();
        }

        @Profile({"dog", "default"})
        @Bean
        PetService dogPetService (PetServiceFactory petServiceFactory){
            return petServiceFactory().getPetService("dog");
        }
        @Profile({"cat"})
        @Bean
        PetService catPetService (PetServiceFactory petServiceFactory){
            return petServiceFactory.getPetService("cat");
        }

        @Bean
        EnglishGreetingRepository englishGreetingRepository () {
            return new EnglishGreetingRepositoryImpl();
        }

        @Profile("EN")
        @Bean
        I18nEnglishGreetingService i18Service (EnglishGreetingRepository englishGreetingRepository){
            return new I18nEnglishGreetingService(englishGreetingRepository);
        }

        @Profile("ES")
        @Bean("i18nService")
        I18SpanishGreetingService i18nService () {
            return new I18SpanishGreetingService();
        }


        @Primary
        @Bean
        PrimaryGreetingService primaryGreetingService () {
            return new PrimaryGreetingService();
        }


        @Bean
        ConstructorGreetingService constructorGreetingService () {
            return new ConstructorGreetingService();
        }

        @Bean
        PropertyInjectedGreetingService propertyInjectedGreetingService () {
            return new PropertyInjectedGreetingService();
        }

        @Bean
        SetterInjectedGreetingService setterInjectedGreetingService () {
            return new SetterInjectedGreetingService();
        }
    }
