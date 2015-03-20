package com.hong.helloworld;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PersonDao {
  Person savePerson (Person person);
  List<Person> getAll ();
}
