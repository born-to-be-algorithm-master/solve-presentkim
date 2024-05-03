package kim.present.solve.backjoon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BackjoonTester {

    public static void test(String input, String expected, Class<?> solution) {
        InputStream in = System.in;
        PrintStream out = System.out;
        ByteArrayOutputStream actual = new ByteArrayOutputStream();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(actual));

        try {
            solution.getDeclaredMethod("main", String[].class)
                    .invoke(null, (Object) new String[]{});
        } catch (Exception e) {
            fail(e);
        }

        System.setIn(in);
        System.setOut(out);

        assertEquals(filter(expected), filter(actual.toString()));
    }

    private static String filter(String input) {
        return input.trim().replaceAll("\r", "");
    }
}