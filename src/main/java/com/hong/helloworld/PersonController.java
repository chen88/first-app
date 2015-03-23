package com.hong.helloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class PersonController {

  private final Log log = LogFactory.getLog(this.getClass());

//  @Inject private PersonDao personDao;
  @Autowired private PersonJdbc personJdbc;

  @RequestMapping(value = "/test")
  public String sayHello (@RequestParam(value = "test1", required = false, defaultValue = "Mr.") String test1) {
//    return "Hello World " + test1;
    return "{\"msg\": \"Hello World\"}";
  }

  @RequestMapping(value = "/{name}")
  public String greet (@PathVariable("name") String name) {
    return "Hello " + name;
  }

  @RequestMapping(value = "/me")
  public Person heyHong () {
    return new Person();
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Person saveUser( @RequestBody Person person) {
    return personJdbc.savePerson(person);
  }

  @RequestMapping(value ="/getUsers")
  public List<Person> getUsers () {
    return personJdbc.getAll();
  }

}
