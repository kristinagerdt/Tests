import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TransformTest {

    Function<String, String> toUpperCase = String::toUpperCase;
    Predicate<String> isLengthThree = s -> s.length() == 3;

    Function<String, String> toLowerCase = String::toLowerCase;
    Predicate<String> isLengthFour = s -> s.length() == 4;

    String sentence = "abCd aad BBEF aBb Fg";

    @Test
    public void testMultiSentenceToUpper() throws Exception {
        String actual = Transform.transform(sentence, isLengthThree, toUpperCase);
        assertEquals("Output", "abCd AAD BBEF ABB Fg", actual);
    }

    @Test
    public void testMultiSentenceToLower() throws Exception {
        String actual = Transform.transform(sentence, isLengthFour, toLowerCase);
        assertEquals("Output", "abcd aad bbef aBb Fg", actual);
    }

    @Test
    public void testEmptySentenceToUpper() throws Exception {
        String actual = Transform.transform("", isLengthThree, toUpperCase);
        assertEquals("Output", "", actual);
    }

    @Test
    public void testEmptySentenceToLower() throws Exception {
        String actual = Transform.transform("", isLengthFour, toLowerCase);
        assertEquals("Output", "", actual);
    }

    @Test
    public void testOneWordSentenceToUpper() throws Exception {
        String actual = Transform.transform("aDa", isLengthThree, toUpperCase);
        assertEquals("Output", "ADA", actual);
    }

    @Test
    public void testOneWordSentenceToLower() throws Exception {
        String actual = Transform.transform("aDaF", isLengthFour, toLowerCase);
        assertEquals("Output", "adaf", actual);
    }

    @Test
    public void testOneWordSentenceLength5ToUpper() throws Exception {
        String actual = Transform.transform("aDaFf", isLengthThree, toUpperCase);
        assertEquals("Output", "aDaFf", actual);
    }

    @Test
    public void testOneWordSentenceLength5ToLower() throws Exception {
        String actual = Transform.transform("aDaFf", isLengthFour, toLowerCase);
        assertEquals("Output", "aDaFf", actual);
    }

    @Test(expected = IncorrectInputDataException.class)
    public void testNullSentenceToUpper() throws Exception {
        String actual = Transform.transform(null, isLengthThree, toUpperCase);
        assertNull("Output", actual);
    }
}
