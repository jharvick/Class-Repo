package org.example;

public class Person {

    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        setName(name);
        setAge(age);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Field cannot be blank");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Field cannot be blank and must contain a '@'");
        }
        this.email = email;
    }

    public class Main{
        public static void main(String[] args) {
            Person person = new Person("Klay Thompson", 33, "klay@warriors.com");

            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Email: " + person.getEmail());

        }
    }

}