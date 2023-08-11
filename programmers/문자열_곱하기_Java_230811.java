package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class 문자열_곱하기_Java_230811 {

    /*
        문자열 my_string과 정수 k가 주어질 때,
        my_string을 k번 반복한 문자열을 return 하는 solution 함수를 작성해 주세요.


     */
    public String solution_pojo(String my_string, int k) {
        String answer = "";

        for (int i = 0; i < k; i++) {
            answer += my_string;
        }

        return answer;
    }

    public String solution_java11(String my_string, int k) {
        return my_string.repeat(k);
    }

    public String solution_stream(String my_string, int k) {
        return IntStream.range(0, k)
                .mapToObj(i -> my_string)
                .collect(Collectors.joining());
    }
}