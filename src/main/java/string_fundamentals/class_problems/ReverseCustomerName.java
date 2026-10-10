package string_fundamentals.class_problems;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        char[] reversed = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }
        return new String(reversed);          // the original string is never modified
    }

    public static void main(String[] args) {
        try {
            String customerName = "Sunil";
            System.out.println("Original Name: " + customerName);
            System.out.println("Reversed Name: " + reverseCustomerName(customerName));
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
