import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("level", "madam", "racecar", "hello");
        String longestPalindrome = words.stream()
                .filter(LongestPalindromicSubstring::isPalindrome)
                .max(Comparator.comparingInt(String::length))
                .get();

        System.out.println(longestPalindrome);
    }

    static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
