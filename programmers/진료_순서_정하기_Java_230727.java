package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class 진료_순서_정하기_Java_230727 {
    /*
        외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 진료 순서를 정하려고 합니다.
        정수 배열 emergency가 매개변수로 주어질 때 응급도가 높은 순서대로
        진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.
     */
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        // 응급도를 내림차순으로 정렬하여 정렬 배열에 저장합니다.
        int[] 정렬 = Arrays.stream(emergency)
                .boxed()
                .sorted((a, b) -> Integer.compare(b, a))
                .mapToInt(Integer::intValue)
                .toArray();

        // 각 응급도에 대한 순서를 찾아서 answer 배열에 저장합니다.
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < 정렬.length; j++) {
                if (emergency[i] == 정렬[j]) {
                    answer[i] = j + 1; // 인덱스는 0부터 시작하므로, 1을 더해 1-based indexing으로 만듭니다.
                    break;
                }
            }
        }

        return answer;
    }



    public int[] solution2(int[] emergency) {
        // 응급도별 순서를 저장하는 Map을 생성합니다.
        Map<Integer, Integer> map = new HashMap<>();

        // emergency 배열을 복사한 뒤 정렬하여 응급도별로 오름차순으로 정렬된 배열을 생성합니다.
        int[] 정렬 = Arrays.copyOfRange(emergency, 0, emergency.length);
        Arrays.sort(정렬);


        // 정렬된 응급도 배열을 순회하며 응급도별 순서를 Map에 저장합니다.
        // 순서는 배열 길이에서 인덱스를 뺀 값입니다.
        for (int i = 0; i < 정렬.length; i++) {
            int temp = 정렬[i];
            map.put(temp, emergency.length - i);
        }

        // 원래 emergency 배열에 저장된 응급도를 순회하며 Map에서 해당 응급도의 순서를 찾아서 다시 배열에 저장합니다.
        for (int i = 0; i < emergency.length; i++) {
            emergency[i] = map.get(emergency[i]);
        }

        return emergency;
    }
}
