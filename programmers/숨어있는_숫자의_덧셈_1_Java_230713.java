package programmers;

import java.util.stream.IntStream;

class 숨어있는_숫자의_덧셈_1_Java_230713 {
    public int solution(String my_string) {

        int answer = 0;

        for(int i = 0; i < my_string.length(); i++) {
            //숫자면 answer에 더해줌
            if(Character.isDigit(my_string.charAt(i))) {
                answer += my_string.charAt(i) - '0';
            }
        }

        return answer;
    }

    public int solution_stream(String my_string) {
        return my_string.chars()                    // 문자열을 IntStream으로 변환합니다.
                .filter(Character::isDigit)         // 숫자인지 여부를 필터링합니다.
                .map(Character::getNumericValue)    // 문자를 정수로 변환합니다.
                .sum();                             // 정수들의 합계를 구합니다.
    }

    public int solution_short(String my_string) {
        return my_string.chars()                    // 문자열을 IntStream으로 변환합니다.
                .mapToObj(i -> (char) i)            // 정수를 문자로 변환하여 Character 객체로 매핑합니다.
                .filter(Character::isDigit)         // 숫자인지 여부를 필터링합니다.
                .map(String::valueOf)               // 문자를 문자열로 변환합니다.
                .mapToInt(Integer::valueOf)         // 문자열을 정수로 변환합니다.
                .sum();                             // 정수들의 합계를 구합니다.
    }

}