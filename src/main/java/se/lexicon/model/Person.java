package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

  private Integer id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private boolean active;

  public Person(Integer id, String firstName, String lastName, LocalDate birthDate, boolean active) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.active = active;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return active == person.active && Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(birthDate, person.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, birthDate, active);
  }

  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", birthDate=" + birthDate +
            ", active=" + active +
            '}';
  }
}
