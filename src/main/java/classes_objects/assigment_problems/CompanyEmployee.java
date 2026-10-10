package classes_objects.assigment_problems;

// Employee-and-company design (M5). Named CompanyEmployee only to avoid clashing with
// the Employee class from M3 in this same package.
public class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";   // shared by every employee
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static: must not reference any instance field.
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyEmployee("Divya", 65000);
        new CompanyEmployee("Arjun", 30000);
        new CompanyEmployee("Meena", 48000);
        CompanyEmployee.printCompanyInfo();
    }
}
