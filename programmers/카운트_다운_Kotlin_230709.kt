package programmers

class 카운트_다운_Kotlin_230709 {


    private var dp: Array<IntArray> = arrayOf()
    private val target범위 = 100001

    fun solution(target: Int): IntArray {
        // dp [i][0] : i를 만들기 위해 필요한 최소 다트 수
        // dp [i][1] : i를 만들기 위해 필요한 최소 싱글/불 횟수

        dp = Array(target + 1) { IntArray(2) }
        for (i in 1..target) {
            dp[i][0] = target범위
        }

        return 다트_던지기(target)
    }

    private fun 다트_던지기(n: Int): IntArray {
        // dp[n][0]이 초기값인 targetRange와 같을 경우에만 계산을 수행한다.
        if (dp[n][0] == target범위) {
            if (n >= 50) { // 불 맞추기
                val temp = 다트_던지기(n - 50)
                if ((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + 1 > dp[n][1])) {
                    dp[n][0] = 1 + temp[0]
                    dp[n][1] = 1 + temp[1]
                }
            }

            val start = if (n >= 20) 20 else n
            var i = start
            while (i >= 1) {
                var j = 1
                while (j <= 3) {
                    if (n >= i * j) {
                        val temp = 다트_던지기(n - i * j)
                        val cnt = if (j == 1) 1 else 0 // 싱글일 경우 카운트하기
                        if ((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + cnt > dp[n][1])) {
                            dp[n][0] = 1 + temp[0]
                            dp[n][1] = cnt + temp[1]
                        }
                    }
                    j++
                }
                i--
            }
        }

        return dp[n]
    }
}
