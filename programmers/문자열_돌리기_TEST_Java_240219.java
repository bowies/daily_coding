package programmers;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 문자열_돌리기_TEST_Java_240219 {

    @Test
    public void test() {
        문자열_돌리기_Java_240219 solution = new 문자열_돌리기_Java_240219();
        String input = "abcde";
        String 기대값 = "a\nb\nc\nd\ne\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        solution.mainTest(input);

        String 값 = outputStream.toString();

        assertEquals(기대값, 값);
    }
}
