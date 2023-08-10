package programmers


import java.util.Arrays;

public class 인사_고과_Java_230810 {
    /*
    문제 설명
        완호네 회사는 연말마다 1년 간의 인사고과에 따라 인센티브를 지급합니다.
        각 사원마다 근무 태도 점수와 동료 평가 점수가 기록되어 있는데
        만약 어떤 사원이 다른 임의의 사원보다 두 점수가 모두 낮은 경우가 한 번이라도 있다면
        그 사원은 인센티브를 받지 못합니다.
        그렇지 않은 사원들에 대해서는 두 점수의 합이 높은 순으로 석차를 내어
        석차에 따라 인센티브가 차등 지급됩니다. 이때, 두 점수의 합이 동일한 사원들은 동석차이며,
        동석차의 수만큼 다음 석차는 건너 뜁니다.
        예를 들어 점수의 합이 가장 큰 사원이 2명이라면 1등이 2명이고 2등 없이 다음 석차는 3등부터입니다.
        각 사원의 근무 태도 점수와 동료 평가 점수 목록 scores이 주어졌을 때,
        완호의 석차를 return 하도록 solution 함수를 완성해주세요.

    제한 사항
        1 ≤ scores의 길이 ≤ 100,000
        scores의 각 행은 한 사원의 근무 태도 점수와 동료 평가 점수를 나타내며 [a, b] 형태입니다.
        scores[0]은 완호의 점수입니다.
        0 ≤ a, b ≤ 100,000
        완호가 인센티브를 받지 못하는 경우 -1을 return 합니다.
    */

    public static int solution(int[][] scores) {
        int answer = 1;

        // 완호의 근무 태도 점수와 동료 평가 점수를 가져옵니다.
        int[] 완호_점수 = scores[0];
        int 동료_평가_점수 = Arrays.stream(scores[0]).sum();

        // 점수를 두 점수의 합이 높은 순으로 정렬합니다.
        // 만약 두 점수의 합이 같다면 근무 태도 점수가 높은 순으로 정렬합니다.
        Arrays.sort(scores, (i, j) -> {
            if (i[0] == j[0]) {
                return Integer.compare(i[1], j[1]);
            } else {
                return Integer.compare(j[0], i[0]);
            }
        });

        // 인센티브 조건을 확인하며 석차를 계산합니다.
        int 기준값 = 0;
        for (int[] score : scores) {
            // 완호의 점수보다 근무 태도 점수와 동료 평가 점수가 모두 높으면 인센티브를 받지 못합니다.
            if (완호_점수[0] < score[0] && 완호_점수[1] < score[1]) {
                return -1;
            }
            if (기준값 <= score[1]) {
                // 두 점수의 합이 기준보다 크면 인센티브를 받을 수 있습니다.
                if (동료_평가_점수 < score[0] + score[1]) {
                    answer++;
                }
                기준값 = score[1];
            }
        }
        return answer;
    }
}
