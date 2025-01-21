import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Select a type of contact to add:");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            int output = s.nextInt();
            if (output == 1) {
                Person p1 = getInfo();
                System.out.println("Grade: ");
                int grade = s.nextInt();
                Student s1 = new Student(p1.getFirstName(), p1.getLastName(), p1.getPhoneNumber(), grade);
                contacts.add(s1);
                break;
            }
            if (output == 2) {
                Person p2 = getInfo();
                System.out.println("Subject: ");
                String sub = s.nextLine();
                Teacher t2 = new Teacher(p2.getFirstName(), p2.getLastName(), p2.getPhoneNumber(), sub);
                contacts.add(t2);
                break;
            }
        }
    }
    // getInfo is used to easily access shared characteristics of both Student and Teacher
    // getInfo is used in addContact to make code cleaner
    private Person getInfo() {
        Scanner s2 = new Scanner(System.in);
        System.out.println("First Name: ");
        String fName = s2.nextLine();
        System.out.println("Last Name: ");
        String lName = s2.nextLine();
        System.out.println("Phone Number: ");
        String pNumber = s2.nextLine();
        Person p1 = new Person(fName, lName, pNumber);
        return p1;
    }

    public void printContacts() {
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }

    public void sort(int sortBy) {
        boolean swap;
        for(int i = 0; i < contacts.size() - 1; i++) {
            for(int j = 0; j < contacts.size() - 1 - i; j++) {
                swap = false;

                if(sortBy == 0) {
                    swap = contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0;
                } else if(sortBy == 1) {
                    swap = contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0;
                } else if(sortBy == 2) {
                    swap = contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0;
                }

                if(swap) {
                    Person temp = contacts.get(j);
                    contacts.set(j,contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }


}
