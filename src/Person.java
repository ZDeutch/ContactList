// Person is the super class for the program
// A person has a first name, last name, and phone number
public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String fName, String lName, String pNumber) {
        firstName = fName;
        lastName = lName;
        phoneNumber = pNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
