package programmers

class 인사_고과_Kotlin.230810 {
    fun solution(scores: Array<IntArray>): Int {
        
        var answer = 1

        // 완호의 근무 태도 점수와 동료 평가 점수를 가져옵니다.
        val 완호_점수 = scores[0]
        val 동료_평가_점수 = 완호_점수.sum()

        // 점수를 두 점수의 합이 높은 순으로 정렬합니다.
        // 만약 두 점수의 합이 같다면 근무 태도 점수가 높은 순으로 정렬합니다.
        scores.sortWith(compareBy({ -it[0] }, { it[1] }))

        // 인센티브 조건을 확인하며 석차를 계산합니다.
        var 기준값 = 0
        for (score in scores) {
            // 완호의 점수보다 근무 태도 점수와 동료 평가 점수가 모두 높으면 인센티브를 받지 못합니다.
            if (완호_점수[0] < score[0] && 완호_점수[1] < score[1]) {
                return -1
            }
            if (기준값 <= score[1]) {
                // 두 점수의 합이 기준보다 크면 인센티브를 받을 수 있습니다.
                if (동료_평가_점수 < score[0] + score[1]) {
                    answer++
                }
                기준값 = score[1]
            }
        }
        return answer
    }
}