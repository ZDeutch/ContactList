public class Teacher extends Person {
    private String subject;

    public Teacher(String fName, String lName, String pNumber, String sub) {
        super(fName, lName, pNumber);
        subject = sub;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        //Person toString() prints first name, last name, and phone number
        //Teacher adds subject
        return super.toString() + " Subject: " + subject;
    }
}
