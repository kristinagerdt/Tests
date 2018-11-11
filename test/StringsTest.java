import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringsTest {
    private String sentence;

    @Before
    public void setInputData() {
        sentence = "dhgfj sdhfg ss ght ww vaa vdvd";
    }

    @Test
    public void testCountOfWords() {
        long expected = 2;
        long actual = Strings.countOfWords(sentence, "s");
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyStringCountOfWords() {
        long expected = 0;
        long actual = Strings.countOfWords("", "s");
        assertEquals(expected, actual);
    }

    @Test
    public void testNumberIsDigit() {
        boolean actual = Strings.isDigit("24");
        assertTrue(actual);
    }

    @Test
    public void testNotNumberIsDigit() {
        boolean actual = Strings.isDigit("2,4");
        assertFalse(actual);
    }

    @Test
    public void testEmptyStringIsDigit() {
        boolean actual = Strings.isDigit("");
        assertEquals(true, actual);
    }
}