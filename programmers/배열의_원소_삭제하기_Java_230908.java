package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class 배열의_원소_삭제하기_Java_230908 {

    /*
    정수 배열 arr과 delete_list가 있습니다.
    arr의 원소 중 delete_list의 원소를 모두 삭제하고
    남은 원소들은 기존의 arr에 있던 순서를 유지한 배열을 return 하는 solution 함수를 작성해 주세요.


     */
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> 삭제할원소 = new ArrayList<>();
        for (int num : delete_list) {
            삭제할원소.add(num);
        }

        List<Integer> 저장할원소 = new ArrayList<>();
        for (int num : arr) {
            // 삭제할 원소가 아닌 경우에만 결과 리스트에 추가
            if (!삭제할원소.contains(num)) {
                저장할원소.add(num);
            }
        }


        int[] answer = new int[저장할원소.size()];
        for (int i = 0; i < 저장할원소.size(); i++) {
            answer[i] = 저장할원소.get(i);
        }

        return answer;
    }




    public int[] solution_best(int[] arr, int[] delete_list) {
        return IntStream.of(arr).filter(i -> !IntStream.of(delete_list).anyMatch(s -> s == i)).toArray();
    }

}