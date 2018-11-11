import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transform {

    public static String transform(String sentence,
                                   Predicate<String> p,
                                   Function<String, String> f) throws IncorrectInputDataException {
        if (sentence != null) {
            return Stream.of(sentence.split(" "))
                    .map(s -> p.test(s) ? f.apply(s) : s)
                    .collect(Collectors.joining(" "));
        } else {
            throw new IncorrectInputDataException("Input data is null!");
        }
    }
}