package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class 배열_회전시키기_Java_240306 {

    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        if (direction.equals("left")) {
            for (int i = 0; i < numbers.length - 1; i++) {
                answer[i] = numbers[i + 1];
            }
            answer[numbers.length - 1] = numbers[0];
        } else if (direction.equals("right")) {
            for (int i = 1; i < numbers.length; i++) {
                answer[i] = numbers[i - 1];
            }
            answer[0] = numbers[numbers.length - 1];
        }

        return answer;
    }


    //↓ stream 전문가 정답
    public int[] solution_stream(int[] numbers, String direction) {
        // 1. 배열을 리스트로 변환하기
        // Arrays.stream(numbers)를 통해 numbers 배열을 IntStream으로 변환하고,
        // boxed()를 사용하여 각 요소를 Integer 객체로 박싱하여 Integer 객체의 스트림으로 변환한다
        // 그리고 collect(Collectors.toList())를 사용하여 Integer 객체의 리스트로 변환한다
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        if (direction.equals("right")) {
            // 2. 회전 방향에 따라 리스트를 조작하기
            // "right" 방향 회전:
            // 리스트의 가장 마지막 요소를 리스트의 첫 번째 위치에 추가한다
            list.add(0, list.get(list.size() - 1));
            // 리스트의 가장 마지막 요소를 제거하여 오른쪽으로 한 칸씩 회전한다
            list.remove(list.size() - 1);
        } else {
            // "left" 방향 회전:
            // 리스트의 첫 번째 요소를 리스트의 마지막 위치에 추가한다
            list.add(list.size(), list.get(0));
            // 리스트의 첫 번째 요소를 제거하여 왼쪽으로 한 칸씩 회전한다
            list.remove(0);
        }

        // 3. 변경된 리스트를 다시 배열로 변환하기
        // 변경된 리스트를 다시 스트림으로 변환하고, 각 요소를 int로 변환한 다음 배열로 반환한다
        return list.stream().mapToInt(Integer::intValue).toArray();
    }



}