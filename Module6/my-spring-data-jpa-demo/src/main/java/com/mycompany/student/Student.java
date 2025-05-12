package com.mycompany.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class Student {

  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;
  private int    credits;

  // for JPA only, no use
  public Student() {
  }

  public Student (String first_name, String last_name, int credits) {
    this.firstName = first_name;
    this.lastName  = last_name;
    this.credits   = credits;
  }

  // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String first_name) {
        this.firstName = first_name;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String last_name) {
        this.lastName = last_name;
    }

    public int getCredits () {
        return credits;
    }

    public void setCredits (int credits) {
        this.credits = credits;
    }

@Override
	public String toString () {
          return "Student = " + "id=" + id + ", firstName=" + firstName + 
                 ", lastName=" + lastName + ", credits=" + credits;
	}
}