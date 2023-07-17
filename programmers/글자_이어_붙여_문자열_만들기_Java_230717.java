package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

class 글자_이어_붙여_문자열_만들기_Java_230717 {
    /*
        문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다.
        my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을
        return 하는 solution 함수를 작성해 주세요.
     */

    public String solution(String my_string, int[] index_list) {
        String answer = "";

        String [] my_string_array = my_string.split("");

        for(int i = 0; i < index_list.length; i++){
            answer += my_string_array[index_list[i]];
        }

        return answer;
    }


    public String solution2(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();

        for (int index : index_list) {
            sb.append(my_string.charAt(index));
        }

        return sb.toString();
    }



    public String solution_stream(String my_string, int[] index_list) {
        return Arrays.stream(index_list)
                .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                .collect(Collectors.joining());
        // 위 코드에서는 Arrays.stream(index_list)를 통해 index_list 배열을 스트림으로 변환합니다.
        // 그리고 mapToObj를 사용하여 각 인덱스에 해당하는 문자를 문자열로 변환하고,
        // Collectors.joining()을 사용하여 문자열을 이어붙여 최종 결과를 얻습니다.
    }


}