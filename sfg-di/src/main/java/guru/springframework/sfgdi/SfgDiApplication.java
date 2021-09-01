package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		//https://stackoverflow.com/questions/19615972/application-context-what-is-this
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("----The best pet is----");
		System.out.println(petController.whichPetIsTheBest());

		I18nContoller i18nContoller = (I18nContoller) ctx.getBean("i18nContoller");
		System.out.println(i18nContoller.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");


		System.out.println("-----Primary bean");
		System.out.println(myController.sayHello());


		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-----Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-----Constructor");
		ConstuctorInjectedController constuctorInjectedController=(ConstuctorInjectedController) ctx.getBean("constuctorInjectedController");
		System.out.println(constuctorInjectedController.getGreeting());
	}


}
