package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstuctorInjectedController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {


		//https://stackoverflow.com/questions/19615972/application-context-what-is-this
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");


		System.out.println("-----Primary bean");
		System.out.println(myController.sayHello());

		//Bean je objekt u springu
		//ApplicationContext se brine o konfiguraciji beansa tj. objekata

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
