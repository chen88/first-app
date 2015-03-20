package com.hong.helloworld;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class Person {
  public int id;
  public String firstName;
  public String lastName;
  public int age;
  public String role;
  public LocalDateTime created;

  public Person () {
    this.id = 1;
    this.firstName = "Hong";
    this.lastName = "Chen";
    this.age = 26;
    this.role = "Software Developer";
    this.created = LocalDateTime.now();
  }

  @GeneratePojoBuilder(withFactoryMethod = "newBuilder", withCopyMethod = true)
  public Person(String firstName, String lastName, int age, String role, LocalDateTime created) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.role = role;
    this.created = created;
  }

  @GeneratePojoBuilder(withFactoryMethod = "newBuilder", withCopyMethod = true)
  public Person(int id, String firstName, String lastName, int age, String role, LocalDateTime created) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.role = role;
    this.created = created;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", role='" + role + '\'' +
        ", created=" + created +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    if (age != person.age) return false;
    if (id != person.id) return false;
    if (created != null ? !created.equals(person.created) : person.created != null) return false;
    if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
    if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
    if (role != null ? !role.equals(person.role) : person.role != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + age;
    result = 31 * result + (role != null ? role.hashCode() : 0);
    result = 31 * result + (created != null ? created.hashCode() : 0);
    return result;
  }
}
