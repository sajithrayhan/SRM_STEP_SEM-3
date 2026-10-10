package string_operations.class_problems;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        StringBuilder sb = new StringBuilder(phone.substring(6));   // last 4 digits
        sb.insert(0, "XXXXXX-");
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(maskPhoneNumber("9876543210"));   // XXXXXX-3210
            System.out.println(maskPhoneNumber("98765"));        // Invalid phone number
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
