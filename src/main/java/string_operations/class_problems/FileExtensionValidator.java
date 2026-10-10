package string_operations.class_problems;

public class FileExtensionValidator {

    static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot < 0 || dot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }
        String extension = filename.substring(dot + 1);
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        try {
            System.out.println(validateFileExtension("Assignment1.PDF"));   // Accepted
            System.out.println(validateFileExtension("notes.txt"));         // Rejected
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
