package com.hong.helloworld;

import net.karneim.pojobuilder.GeneratePojoBuilder;

public class Person {
    public String firstName;
    public String lastName;
    public int age;
    public String role;

    @GeneratePojoBuilder(withFactoryMethod = "newBuilder", withCopyMethod = true)
    public Person(String firstName, String lastName, int age, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!firstName.equals(person.firstName)) return false;
        if (!lastName.equals(person.lastName)) return false;
        if (!role.equals(person.role)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        result = 31 * result + role.hashCode();
        return result;
    }

}
