package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class 등수_매기기_Java_240828 {
    
    public int[] solution_stream_others(int[][] score) {
        return Arrays.stream(score) // Stream으로 배열 변환 
            .map(ints -> // 각 학생의 점수 배열인 ints를 Stream으로 변환
                Arrays.stream(ints).average().orElse(0)) //점수 배열의 평균을 계산하는데, 없으면 0
            .mapToInt(d -> 
                // 다시 score 배열을 Stream으로 변환하여 각 학생의 평균 점수를 계산
                Arrays.stream(score)
                    .map(ints -> Arrays.stream(ints).average().orElse(0)) //평균을 계산하는데, 없으면 0
                    // 평균 점수를 내림차순으로 정렬 
                    .sorted(Comparator.reverseOrder())
                    // 정렬된 평균 점수 리스트를 생성 
                    .collect(Collectors.toList())
                    // 리스트에서 현재 평균 점수 d의 위치를 찾아 인덱스(등수)를 구함
                    .indexOf(d) + 1)
            // 최종 결과를 배열로 변환하여 반환
            .toArray();
    }

    public int[] solution(int[][] score) {
        int length = score.length;
        double[] avgs = new double[length];
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
			//평균 - double로 사용
            avgs[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        for (int i = 0; i < length; i++) {
			//등수 - 전 수 비교
            int temp = 1;
            for (int j = 0; j < length; j++) {
                if (avgs[j] > avgs[i]) {
                    temp++;
                }
            }
            answer[i] = temp;
        }

        return answer;
    }
}
