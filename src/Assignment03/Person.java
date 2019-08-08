package Assignment03;

public class Person {
    private char priority;
    private String firstName;
    private String lastName;

    public Person(char priority, String firstName, String lastName) {
        this.priority = priority;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
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

    @Override
    public String toString() {
        return priority + ": " + firstName + " " + lastName;
    }
}
