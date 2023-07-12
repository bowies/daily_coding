package programmers;

import java.util.Arrays;

class 뒤에서_5등_위로_Java_230712 {
    /*
        정수로 이루어진 리스트 num_list가 주어집니다.
        num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     */
    public int[] solution(int[] num_list) {

        Arrays.sort(num_list);

        int[] answer = new int[num_list.length - 5];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = num_list[i + 5];
        }


        return answer;
    }


    public int[] solution_stream(int[] num_list) {
        return Arrays.stream(num_list).sorted().skip(5).toArray();
        /*
            위의 코드는 `solution_stream` 함수로, 입력으로 받은 `num_list`를 스트림으로 변환한 후에 다음과 같은 작업을 수행합니다:

            1. `Arrays.stream(num_list)`을 사용하여 `num_list`를 스트림으로 변환합니다.
            2. `sorted()`를 호출하여 스트림 요소를 정렬합니다.
            3. `skip(5)`를 호출하여 처음부터 5개의 요소를 건너뜁니다.
            4. `toArray()`를 호출하여 스트림 요소들을 정수 배열로 변환합니다.
            5. 최종적으로 정수 배열을 반환합니다.

            따라서, 이 함수는 주어진 `num_list`에서 가장 작은 5개의 수를 제외한 나머지 수를 오름차순으로 정렬하여 정수 배열로 반환합니다.
         */
    }
}