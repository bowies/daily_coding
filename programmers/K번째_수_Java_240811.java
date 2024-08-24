package programmers;

import java.util.Arrays;

class K번째_수_Java_240811 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];

            int[] temp = Arrays.copyOfRange(array, a - 1, b);
            //부분 배열 만드는 copyOfRange!!!

            Arrays.sort(temp);

            answer[i] = temp[c - 1];
        }

        return answer;
    }
}
