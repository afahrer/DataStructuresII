package Assignment05.Qu1;

public class Employee {
    private int empID;
    private String firstName;
    private String lastName;
    private String department;
    private int yearsOfService;

    public Employee(int empID) {
        this.empID = empID;
    }

    public Employee(int empID, String firstName, String lastName, String department, int yearsOfService) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.yearsOfService = yearsOfService;
    }

    public int getEmpID() {
        return empID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", yearsOfService=" + yearsOfService +
                '}';
    }
}
