package string_operations.assigment_problems;

public class WordReversalEncoder {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int w = 0; w < words.length; w++) {
            StringBuilder reversed = new StringBuilder();
            for (int i = words[w].length() - 1; i >= 0; i--) {
                reversed.append(words[w].charAt(i));
            }
            if (w > 0) {
                result.append(" ");
            }
            result.append(reversed);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));    // olleh bulc
    }
}
