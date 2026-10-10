package string_operations.class_problems;

public class BankTransactionReference {

    // trim, then uppercase only the first 3 characters (substring + concatenation).
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed;
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(reference, 0, 3).append("] DATE: ")
          .append(reference, 3, 5).append("/")
          .append(reference, 5, 7).append("/")
          .append(reference, 7, 9)
          .append(" | SEQ: ").append(reference.substring(9));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }
}
