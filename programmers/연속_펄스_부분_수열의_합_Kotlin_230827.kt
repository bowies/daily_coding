package programmers

class 연속_펄스_부분_수열의_합_Kotlin_230827 {
    /*
        문제:
        주어진 수열의 연속 부분 수열에 같은 길이의 펄스 수열을 각 원소끼리 곱하여 연속 펄스 부분 수열을 만들려 합니다.
        펄스 수열이란 [1, -1, 1, -1 ...] 또는 [-1, 1, -1, 1 ...] 과 같이
        1 또는 -1로 시작하면서 1과 -1이 번갈아 나오는 수열입니다.

        예시:
        수열 [2, 3, -6, 1, 3, -1, 2, 4]의 연속 부분 수열 [3, -6, 1]에
        펄스 수열 [1, -1, 1]을 곱하면 연속 펄스 부분 수열은 [3, 6, 1]이 됩니다.
        또 다른 예시로 연속 부분 수열 [3, -1, 2, 4]에
        펄스 수열 [-1, 1, -1, 1]을 곱하면 연속 펄스 부분 수열은 [-3, -1, -2, 4]이 됩니다.

        주어진 정수 수열 sequence가 매개변수로 주어질 때,
        연속 펄스 부분 수열의 합 중 가장 큰 것을 반환하는 solution 함수를 완성하세요.
     */
    fun solution(sequence: IntArray): Long {
        var answer = Long.MIN_VALUE

        val n = sequence.size

        // 0 : [-1, 1, -1, 1, ...]
        // 1 : [1, -1, 1, -1, ...]
        val dp = listOf(LongArray(n), LongArray(n))
        // 펄스 패턴에 따른 연속 부분 수열의 곱 결과를 저장할 dp 리스트

        dp[0][0] = 펄스패턴과_수열원소의_곱(0, 0, sequence)
        dp[1][0] = 펄스패턴과_수열원소의_곱(1, 0, sequence)
        answer = maxOf(dp[0][0], dp[1][0])

        for (i in 1 until n) {
            for (j in 0 until 2) {
                // DP를 이용해서 최대 합 계산
                val summary = 펄스패턴과_수열원소의_곱(j, i, sequence)
                dp[j][i] = maxOf(summary, dp[j][i - 1] + summary)
            }
            // 현재 인덱스에서의 최대 합과 기존의 최대 합을 비교하여 더 큰 값 선택
            answer = maxOf(answer, maxOf(dp[0][i], dp[1][i]))
        }

        return answer
    }

    private fun 펄스패턴과_수열원소의_곱(k: Int, i: Int, sequence: IntArray): Long {
        val answer: Long
        if (i % 2 == 0) { // 짝수 인덱스
            answer = if (k == 0) sequence[i].toLong() * -1 else sequence[i].toLong()
        } else { // 홀수 인덱스
            answer = if (k == 0) sequence[i].toLong() else sequence[i].toLong() * -1
        }
        return answer
    }
}
