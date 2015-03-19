package com.hong.helloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE} )
public class PersonController {

  private Log log = LogFactory.getLog(this.getClass());

  @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
  public String sayHello (@RequestParam(value = "test1", required = false, defaultValue = "Mr.") String test1) {
    return "Hello World " + test1;
//    return "{\"msg\": \"Hello World\"}";
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
  public String greet (@PathVariable("name") String name) {
    return "Hello " + name;
  }

}
