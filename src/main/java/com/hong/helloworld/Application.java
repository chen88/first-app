package com.hong.helloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Hong on 3/18/2015.
 */
@SpringBootApplication
public class Application {

  private static Log log = LogFactory.getLog(Application.class);

  public static void main(String[] args) {
    Person person = new PersonBuilder()
        .withFirstName("Hong")
        .withLastName("Chen")
        .withAge(26)
        .withRole("Developer")
        .build();

//        System.out.println(person.firstName);
    log.debug(person);
    SpringApplication.run(Application.class, args);
  }


}
