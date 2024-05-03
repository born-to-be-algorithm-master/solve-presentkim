package kim.present.solve.backjoon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseTest {

    static void test(String input, String expected, ISolution solution) {
        InputStream in = System.in;
        PrintStream out = System.out;
        ByteArrayOutputStream actual = new ByteArrayOutputStream();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(actual));

        solution.solve();

        System.setIn(in);
        System.setOut(out);

        assertEquals(filter(expected), filter(actual.toString()));
    }

    static String filter(String input) {
        return input.trim().replaceAll("\r", "");
    }
}