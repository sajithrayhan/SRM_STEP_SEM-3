package classes_objects.class_problems;

public class Student {
    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";   // shared by all students
    static int studentCount = 0;

    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method: touches only static fields.
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Asha", 90);
        new Student("Ravi", 85);
        Student.printCollegeInfo();
    }
}
