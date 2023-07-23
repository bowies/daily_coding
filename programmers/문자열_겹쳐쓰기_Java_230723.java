package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class 문자열_겹쳐쓰기_Java_230723 {
    /*
        문자열 my_string, overwrite_string과 정수 s가 주어집니다.
        문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을
        문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.


     */
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());

        return answer;
    }


    public String solution_sb(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();

        sb.append(my_string, 0, s);
        sb.append(overwrite_string);
        sb.append(my_string, s + overwrite_string.length(), my_string.length());

        return sb.toString();
    }


    public String solution_stream(String my_string, String overwrite_string, int s) {
        String result = IntStream.range(0, s)
                .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                .collect(Collectors.joining()) + overwrite_string +
                IntStream.range(s + overwrite_string.length(), my_string.length())
                        .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                        .collect(Collectors.joining());

        return result;
    }


    public String solution_stream_solved(String my_string, String overwrite_string, int s) {
        // StringBuilder를 사용하지 않고, 스트림을 이용하여 문자열 조작을 진행할 것입니다.
        // 주어진 문제에서는 인덱스 s를 기준으로 부분 문자열을 overwrite_string으로 바꿔야 합니다.

        // 인덱스 s 이전의 부분 문자열을 추출합니다.
        String beforeSubstring = IntStream.range(0, s)
                .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                .collect(Collectors.joining());

        // 인덱스 s 이후의 부분 문자열을 추출합니다.
        String afterSubstring = IntStream.range(s + overwrite_string.length(), my_string.length())
                .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                .collect(Collectors.joining());

        // beforeSubstring + overwrite_string + afterSubstring을 합쳐서 최종 결과 문자열을 생성합니다.
        String result = beforeSubstring + overwrite_string + afterSubstring;

        return result;
    }
}