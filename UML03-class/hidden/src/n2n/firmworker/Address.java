package n2n.firmworker;

public class Address {
    String street;
    String number;
    String box;
    String line2;
    String line3;
    int zipCode;
    String city;
    String country;

    public Address(String street, String number, String box,
                   String line2, String line3,
                   int zipCode, String city, String country) {
        this.street = street;
        this.number = number;
        this.box = box;
        this.line2 = line2;
        this.line3 = line3;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
}
