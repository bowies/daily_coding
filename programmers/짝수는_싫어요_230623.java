package programmers;

import java.util.stream.IntStream;

class 짝수는_싫어요_230623 {
    //정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.
    public int[] solution(int n) {
        int counter = (n + 1) / 2;
        int[] answer = new int[counter];
        for (int i = 0; i < counter; i++) {
            answer[i] = 2 * i + 1;
        }

        return answer;

    }
    public int[] solution_stream(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> i % 2 == 1)
                .toArray();
        // 위 코드에서 IntStream.rangeClosed(1, n)는 1부터 n까지의 정수 범위를 생성합니다.
        // 이후 filter(i -> i % 2 == 1)를 통해 홀수만 필터링하고, toArray()를 사용하여 결과를 배열로 변환합니다.
    }
}