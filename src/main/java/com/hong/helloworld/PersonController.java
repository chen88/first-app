package com.hong.helloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class PersonController {

  private Log log = LogFactory.getLog(this.getClass());

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

}
