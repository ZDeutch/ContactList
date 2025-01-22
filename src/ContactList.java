import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    //Instance Variable
    private ArrayList<Person> contacts;

    //Constructor
    ContactList() {
        contacts = new ArrayList<Person>();
    }

    //Getter
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    //Adds a contact to ArrayList
    public void addContact() {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Select a type of contact to add:");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            int output = s.nextInt();

            //Add a Student
            if (output == 1) {
                Person p1 = getInfo();
                System.out.println("Grade: ");
                int grade = s.nextInt();
                Student s1 = new Student(p1.getFirstName(), p1.getLastName(), p1.getPhoneNumber(), grade);
                contacts.add(s1);
                break;
            }
            //Add a Worker
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
    //Prints all contacts in list
    public void printContacts() {
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
        }
    }
    // Sorts the contacts based on the specific feature
    // Either first name, last name, or phone number
    public void sort(int sortBy) {
        boolean swap;
        for(int i = 0; i < contacts.size() - 1; i++) {
            for(int j = 0; j < contacts.size() - 1 - i; j++) {
                swap = false;

                // Only swap if the incremented contact has a attribute that is negative
                if(sortBy == 0) {
                    swap = contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0;
                } else if(sortBy == 1) {
                    swap = contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0;
                } else if(sortBy == 2) {
                    swap = contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0;
                }

                if(swap) {
                    // Swap the contacts
                    Person temp = contacts.get(j);
                    contacts.set(j,contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    // Lists all contacts that are Students
    public void listStudents() {
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i) instanceof Student) {
                System.out.println(contacts.get(i));
            }
        }
    }

    //Searches contact list based on desired factor
    //Either first name, last name, or phone number
    private void Search(int searchBy) {
        Scanner scannerhelp = new Scanner(System.in);
        if(searchBy == 0) { // Search by first name
            int count = 0;
            System.out.println("Enter a name:");
            String fName = scannerhelp.nextLine();
            for(int i = 0; i < contacts.size(); i++) {
                if(contacts.get(i).getFirstName().equals(fName)) {
                    System.out.println(contacts.get(i));
                }
                count++;
            }
            if(count == 0) { // If nothing is printed, tell the user
                System.out.println(fName + " is not in the list");
            }
        } else if(searchBy == 1) { // Search by last name
            int count = 0;
            System.out.println("Enter a name:");
            String lName = scannerhelp.nextLine();
            for(int i = 0; i < contacts.size(); i++) {
                if(contacts.get(i).getLastName().equals(lName)) {
                    System.out.println(contacts.get(i));
                }
                count++;
            }
            if(count == 0) {
                System.out.println(lName + " is not in the list");
            }
        } else if(searchBy == 2) { // Search by phone number
            int count = 0;
            System.out.println("Enter a phone number:");
            String pNumber = scannerhelp.nextLine();
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).getPhoneNumber().equals(pNumber)) {
                    System.out.println(contacts.get(i));
                }
            }
            if(count == 0) {
                System.out.println(pNumber + " is not in the list");
            }
        }
    }
    // Display menu
    public void run() {
        Scanner scanner = new Scanner(System.in);
        // Run forever unless one breaks the while-loop
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. List All Contacts By First Names");
            System.out.println("3. List All Contacts by Last Name");
            System.out.println("4. List All Contacts by Phone Number");
            System.out.println("5. List All Students");
            System.out.println("6. Search by First Name");
            System.out.println("7. Search by Last Name");
            System.out.println("8. Search by Phone Number");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
        // Explain different cases
            if(choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if(choice == 1) {
                addContact();

            } else if(choice == 2) {
                sort(0);
                printContacts();
            } else if(choice == 3) {
                sort(1);
                printContacts();
            } else if(choice == 4) {
                sort(2);
                printContacts();
            } else if(choice == 5) {
                listStudents();
            } else if(choice == 6) {
                Search(0);
            } else if(choice == 7) {
                Search(1);
            } else if(choice == 8) {
                Search(2);
            }
        }

    }
}
