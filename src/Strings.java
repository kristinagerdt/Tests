import java.util.Arrays;
import java.util.List;

public class Strings {

    public static long countOfWords(String sentence, String s) {
        List<String> strings = Arrays.asList(sentence.split(" "));
        return strings
                .stream()
                .filter(p -> p.startsWith(s))
                .count();
    }

    public static boolean isDigit(String string) {
        if (string.length() != 0) {
            return string
                    .chars()
                    .allMatch(Character::isDigit);
        }
        return false;
    }
}
