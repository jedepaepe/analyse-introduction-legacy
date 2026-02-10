package n2nself.socialnetwork;

import java.util.HashSet;

public class Person {
    String firstname;
    String lastname;
    String email;
    String phone;
    HashSet<Person> friends = new HashSet<>();

    public Person(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }
}
