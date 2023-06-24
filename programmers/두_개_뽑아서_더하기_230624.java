package programmers;

import java.util.*;
class 두_개_뽑아서_더하기_230624 {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int index = 0;
        for (int num : set) {
            answer[index++] = num;
        }

        Arrays.sort(answer);

        return answer;
    }



    public int[] solution_stream_short(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}