package encapsulation.class_problems;

public class Locker {
    private final int lockerNumber;
    private String code;            // write-only: there is deliberately no getter

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            return false;           // wrong current code: do nothing else
        }
        code = newCode;
        return true;
    }

    // Lets a member test a code without ever revealing the real one.
    public boolean matches(String attempt) {
        return code.equals(attempt);
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println("changeCode(1234 -> 5678): " + l.changeCode("1234", "5678"));
        System.out.println("changeCode(0000 -> 9999): " + l.changeCode("0000", "9999"));
        System.out.println("Code is still 5678? " + l.matches("5678"));
    }
}
