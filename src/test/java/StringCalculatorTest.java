import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.SplittableRandom;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    //test for exceptions
    @Test
    void testAdd1() {
        Exception e = assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("-1,2"));
        assertTrue("Negatives not allowed".equals(e.getLocalizedMessage()));
    }

    @Test
    void testAdd2() {
        Exception e = assertThrows(IllegalArgumentException.class, ()->StringCalculator.add("5,4,7,-9"));
        assertTrue("Negatives not allowed".equals(e.getLocalizedMessage()));
    }

    //test for ignoring big numbers
    @Test
    void testAdd3() {
        int result = StringCalculator.add("1,1000");
        assertEquals(1, result);
    }
    @Test
    void testAdd4() {
        int result = StringCalculator.add("1,999");
        assertEquals(1000, result);
    }
    @Test
    void testAdd5() {
        int result = StringCalculator.add("1001");
        assertEquals(0, result);
    }
    @Test
    void testAdd6() {
        int result = StringCalculator.add("1001, 1002");
        assertEquals(0, result);
    }

}
