package classes_objects.assigment_problems;

public class Employee {
    private final String empId;
    private final String empName;
    private final double salary;
    private boolean isIntern;

    // Permanent employee.
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Intern: chains to the three-argument constructor with salary 0, then marks as intern.
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");
        permanent.printProfile();
        intern.printProfile();
    }
}
