package programmers;

import java.util.Arrays;
import java.util.stream.Stream;

public class 배열의_원소만큼_추가하기_Java_230909 {
    /*

        아무 원소도 들어있지 않은 빈 배열 X가 있습니다.
        양의 정수 배열 arr가 매개변수로 주어질 때,
        arr의 앞에서부터 차례대로 원소를 보면서
        원소가 a라면 X의 맨 뒤에 a를 a번 추가하는 일을
        반복한 뒤의 배열 X를 return 하는 solution 함수를 작성해 주세요.
     */
    public int[] solution(int[] arr) {

        int[] answer = new int [Arrays.stream(arr).sum()];
        int counter = 0;

        for(int i = 0; i < arr.length; i++){
           for(int j = 0; j < arr[i]; j++){
               answer[counter++] = arr[i];
           }
        }


        return answer;
    }


    public int[] solution_short(int[] arr) {
        String answer = "";

        for(int i: arr) {
            answer += (String.valueOf(i)+",").repeat(i);
        }
        return Stream.of(answer.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
