package hw;

import java.util.Arrays;
import java.util.Scanner;
class Anagrams {
    public static boolean checker(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1, w2);
    }

    static void main() {
        String word1 = "";
        String word2 = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter word 1.");
            word1 = scanner.nextLine();
            System.out.println("Enter word 2.");
            word2 = scanner.nextLine();
            if(checker(word1, word2)) {
                System.out.println("These words are anagrams!\n");
            }
            else{
                System.out.println("These words are not anagrams.\n");
            }
        }
    }
}