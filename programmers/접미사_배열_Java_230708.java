package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

class 접미사_배열_Java_230708 {
    /*
        어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다.
        예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
        문자열 my_string이 매개변수로 주어질 때,
        my_string의 모든 접미사를 사전순으로 정렬한 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
     */
    public String[] solution(String my_string) {


        int length = my_string.length();
        String [] 접미사 = new String[length];

        for(int i = 0; i < length; i++){
            접미사[i] = my_string.substring(i);
        }

        Arrays.sort(접미사);

        return 접미사;
    }

    public String[] solution_stream(String myString) {
        return IntStream.range(0, myString.length()).mapToObj(myString::substring).sorted().toArray(String[]::new);
        /*

        1. `IntStream.range(0, myString.length())`을 사용하여
        0부터 `myString`의 길이 - 1까지의 정수 스트림을 생성합니다. 이 스트림은 인덱스를 나타냅니다.

        2. `mapToObj(myString::substring)`을 사용하여 각 인덱스를 해당 인덱스부터 끝까지의 부분 문자열로 매핑합니다.
        이렇게 생성된 스트림은 문자열의 모든 접미사를 나타냅니다.

        3. `sorted()`를 사용하여 접미사를 사전순으로 정렬합니다.

        4. `toArray(String[]::new)`를 사용하여 정렬된 스트림을 문자열 배열로 변환하여 반환합니다. //★
        따라서, `solution` 메서드는 주어진 문자열의 모든 접미사를 사전순으로 정렬한 결과를 문자열 배열로 반환합니다.

         */
    }
}