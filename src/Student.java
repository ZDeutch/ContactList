public class Student extends Person {
    private int grade;

    public Student(String fName, String lName, String pNumber, int g) {
        super(fName, lName, pNumber);
        grade = g;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        //Person toString() prints first name, last name, and phone number
        //Student adds grade
        return super.toString() + " Grade: " + grade;
    }
}
