package com.hong.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class PersonJdbc implements PersonDao {

  @Autowired
  JdbcTemplate jdbc;

  private PersonJdbc (JdbcTemplate jdbc) {
    this.jdbc = jdbc;

    this.jdbc.execute("CREATE TABLE IF NOT EXISTS PersonDb " +
            "(id INT IDENTITY(1,1) NOT NULL" +
            "firstName VARCHAR(20), " +
            "lastName VARCHAR(20), " +
            "age INT, " +
            "role VARCHAR(30), " +
            "created DATETIME)");
  }

  @Override
  public Person savePerson (Person person) {
    jdbc.execute("");
    return person;
  }

  @Override
  public List<Person> getAll () {
    List<Person> personList = new ArrayList<Person>();
    return personList;
  }
}
