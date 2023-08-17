package programmers

import java.util.HashMap

class 시소_짝꿍_Kotlin_230817 {

    /*
        어느 공원 놀이터에는 시소가 하나 설치되어 있습니다.
        이 시소는 중심으로부터 2(m), 3(m), 4(m) 거리의 지점에 좌석이 하나씩 있습니다.
        이 시소를 두 명이 마주 보고 탄다고 할 때,
        시소가 평형인 상태에서 각각에 의해 시소에 걸리는 토크의 크기가 서로 상쇄되어 완전한 균형을 이룰 수 있다면
        그 두 사람을 시소 짝꿍이라고 합니다.
        즉, 탑승한 사람의 무게와 시소 축과 좌석 간의 거리의 곱이 양쪽 다 같다면 시소 짝꿍이라고 할 수 있습니다.
        사람들의 몸무게 목록 weights이 주어질 때,
        시소 짝꿍이 몇 쌍 존재하는지 구하여 return 하도록 solution 함수를 완성해주세요.
     */
    fun solution(weights: IntArray): Long {
        weights.sort()

        var answer: Long = 0

        val map = HashMap<Double, Int>()
        // 무게 - 해당 무게 개수

        for (i in weights) {
            // 무게의 형태를 double로 변환
            val d = i * 1.0 // 현재 무게

            // 각 경우의 무게 계산
            val d2 = (i * 1.0) / 2.0 // 시소 축과 좌석 간의 거리가 2m인 경우
            val d3 = (i * 2.0) / 3.0 // 시소 축과 좌석 간의 거리가 3m인 경우
            val d4 = (i * 3.0) / 4.0 // 시소 축과 좌석 간의 거리가 4m인 경우

            // 각 경우의 무게가 맵에 존재하면 answer에 해당 무게의 개수를 더함
            if (map.containsKey(d)) answer += map[d]!! // 시소 축과 좌석 간의 거리가 1m인 경우
            if (map.containsKey(d2)) answer += map[d2]!! // 시소 축과 좌석 간의 거리가 2m인 경우
            if (map.containsKey(d3)) answer += map[d3]!! // 시소 축과 좌석 간의 거리가 3m인 경우
            if (map.containsKey(d4)) answer += map[d4]!! // 시소 축과 좌석 간의 거리가 4m인 경우

            // 현재 무게를 맵에 추가하거나 기존 무게의 개수를 증가시킴
            map[i * 1.0] = map.getOrDefault(i * 1.0, 0) + 1
        }

        return answer // 최종적으로 시소 짝꿍의 쌍의 개수를 반환
    }
}
