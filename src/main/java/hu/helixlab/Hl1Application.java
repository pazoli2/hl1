package hu.helixlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.helixlab.simple.S1;

/**
 * Web app starter (embeded Tomcat...)
 * 
 * @author erbalazs
 */
// @SpringBootApplication
public class Hl1Application {

	public static void main(String[] args) {

		// -Xms256m -Xmx512m -XX:+CMSClassUnloadingEnabled -XXaltjvm="dcevm" -javaagent:d:\\Apps\\JDK\\hotswap-agent.jar=autoHotswap=true

		// SpringApplication.run(Hl1Application.class, args);
		
		S1.m1();
		
		
	}
}
