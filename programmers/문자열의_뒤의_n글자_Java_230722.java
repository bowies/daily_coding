package programmers;

import java.util.stream.IntStream;

class 문자열의_뒤의_n글자_Java_230722 {
    /*
        문자열 my_string과 정수 n이 매개변수로 주어질 때,
        my_string의 뒤의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
     */
    public String solution(String my_string, int n) {
        String answer = my_string.substring(my_string.length()-n, my_string.length());
        return answer;
    }
    public String solution2(String my_string, int n) {
        int index = my_string.length() - n;
        return my_string.substring(index);
    }

    public String solution_stream(String my_string, int n) {
        return IntStream.range(my_string.length() - n, my_string.length())
                //IntStream을 사용하여 인덱스 범위를 생성하고, 해당 인덱스 위치의 문자들을 가져오도록 하였습니다.
                .mapToObj(i -> my_string.charAt(i))
                //mapToObj를 사용하여 char을 Character로 박싱하여 Stream을 Stream<Character> 타입으로 변경했습니다.
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                //collect 메서드를 이용하여 StringBuilder에 문자들을 추가하고, 최종적으로 문자열로 변환하여 반환하도록 구현했습니다.
                .toString();
    }

}