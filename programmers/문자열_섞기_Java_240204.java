package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class 문자열_섞기_Java_240204 {
    public String solution(String str1, String str2) {
        String answer = IntStream.range(0, str1.length())
                .mapToObj(i -> str1.charAt(i) + "" + str2.charAt(i))
                .collect(Collectors.joining());
        return answer;
    }

}
