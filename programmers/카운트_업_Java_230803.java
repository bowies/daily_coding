package programmers;

import java.util.stream.IntStream;

class 카운트_업_Java_230803 {
    /*
        정수 start와 end가 주어질 때,
        start부터 end까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     */

    public int[] solution(int start, int end) {
        int[] answer = new int[end - start + 1];

        for (int i = start; i <= end; i++) {
            answer[i - start] = i;
        }

        return answer;
    }
    public int[] solution_stream(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }
}