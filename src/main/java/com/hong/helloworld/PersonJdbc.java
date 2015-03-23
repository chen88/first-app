package com.hong.helloworld;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

@Component
public class PersonJdbc implements PersonDao {
  private final Log log = LogFactory.getLog(this.getClass());
  @Autowired private JdbcTemplate jdbc;

  @PostConstruct
  private void PersonJdbc () {
    this.jdbc.execute("CREATE TABLE IF NOT EXISTS PersonDb " +
            "(id INT AUTO_INCREMENT PRIMARY KEY," +
            "firstName VARCHAR(20), " +
            "lastName VARCHAR(20), " +
            "age INT, " +
            "role VARCHAR(30), " +
            "created DATETIME DEFAULT CURRENT_TIMESTAMP)");

    log.debug("created with: " + jdbc);
  }

  @Override
  public Person savePerson (Person person) {
    //"INSERT INTO customers(first_name,last_name) values(?,?)",
    int updatedRowNumb = jdbc.update("INSERT INTO PersonDb(firstName, lastName, age, role) values(?, ?, ?, ?)",
        person.firstName, person.lastName, person.age, person.role);
    return person;
  }

  @Override
  public List<Person> getAll () {
    List<Person> personList = jdbc.query("SELECT * FROM PersonDb", (rs, rowNum) -> personMapper(rs, rowNum));
    return personList;
  }

  public Person personMapper (ResultSet rs, int rowNum) throws SQLException {
    return new PersonBuilder()
        .withId(rs.getInt("id"))
        .withFirstName(rs.getString("firstName"))
        .withLastName(rs.getString("lastName"))
        .withAge(rs.getInt("age"))
        .withRole(rs.getString("role"))
        .withCreated(rs.getTimestamp("created").toLocalDateTime())
        .build();
  }
}
