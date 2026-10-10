package encapsulation.assigment_problems;

public class PasswordChecker {
    private final String password;     // never exposed, never changed

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        }
        if (length < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());          // Weak
        System.out.println(new PasswordChecker("abcdefgh").getStrength());      // Medium
        System.out.println(new PasswordChecker("abcdefghij").getStrength());    // Strong
        System.out.println(new PasswordChecker("abcdefghijkl").getStrength());  // Strong
    }
}
