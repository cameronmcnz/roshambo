package roshambo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "roshambo", "com.mcnz","com.webage", "com.mcnz.rps", "com"} )
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
