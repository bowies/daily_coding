package programmers;

import java.util.stream.IntStream;

class 카운트_다운_Java_230718 {
    /*
        정수 start와 end가 주어질 때,
        start에서 end까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     */
    public int[] solution(int start, int end) {
        // 결과를 저장할 배열 생성
        int[] answer = new int[start - end + 1];

        // 배열에 값을 할당하는 반복문
        for(int i = 0; i < answer.length; i++) {
            answer[i] = start - i;
        }

        // 결과 배열 반환
        return answer;
    }

    public int[] solution_stream(int start, int end) {
        // IntStream을 사용하여 start에서 end까지의 범위 생성
        // rangeClosed는 end부터 start까지의 범위를 생성
        // map을 사용하여 각 요소를 변환하여 배열로 반환
        return IntStream.rangeClosed(end, start)
                .map(i -> start - i + end)
                .toArray();
    }
}