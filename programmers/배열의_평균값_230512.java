package programmers;

import java.util.Arrays;

class 배열의_평균값_230512 {
    public double solution(int[] numbers) {
        double answer = 0;
        for(int i = 0; i < numbers.length; i++) {
            answer += numbers[i];
        }

        return answer/numbers.length;
    }


    public double solution2(int[] numbers) {
        //average()는 double을 반환하므로 orElse()를 통해 0을 반환하도록 설정
        //orElse()는 Optional 객체가 비어있을 경우에만 실행
        return Arrays.stream(numbers).average().orElse(0);
    }
}