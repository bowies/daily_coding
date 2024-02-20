package programmers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 구슬을_나누는_경우의_수_TEST_Java_240220 {

    @Test
    public void testSolution() {
        구슬을_나누는_경우의_수_Java_240220 solution = new 구슬을_나누는_경우의_수_Java_240220();

        int[][] 테스트케이스 = {
            {3, 2, 3},
            {5, 3, 10}
        };

        for (int[] 테스트 : 테스트케이스) {
            int balls = 테스트[0];
            int share = 테스트[1];
            int expected = 테스트[2];

            int result = solution.solution(balls, share);

            assertEquals(expected, result);
        }
    }

}
