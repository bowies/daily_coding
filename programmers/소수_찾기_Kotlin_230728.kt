package programmers

class 소수_찾기_Kotlin_230728 {
    // BooleanArray는 Kotlin에서 배열을 생성하는 방법이며, for 루프의 구문이 조금 다를 수 있습니다.
    // 또한, Kotlin에서는 while 루프를 사용하는 것도 가능하므로, for 루프를 while 루프로 변경한 부분도 있습니다.

    fun solution(n: Int): Int {
        val isPrime = BooleanArray(n + 1)
        var count = 0

        // 모든 수를 소수로 가정하고 초기화
        for (i in 2..n) {
            isPrime[i] = true
        }

        // 에라토스테네스의 체 알고리즘
        for (i in 2..n) {
            if (isPrime[i]) {
                var j = i * i
                while (j <= n) {
                    isPrime[j] = false
                    j += i
                }
            }
        }

        // 소수 개수 세기
        for (i in 2..n) {
            if (isPrime[i]) {
                count++
            }
        }

        return count
    }

    fun solution_최적화(n: Int): Int {
        // 주어진 n 이하의 소수를 찾는데, 이때 n이 최대 1,000,000 이하의 자연수라는 조건이 있으므로, 약간의 최적화를 추가
        if (n < 2) {
            return 0 // 1보다 작거나 같은 수는 소수가 없음
        }

        val isPrime = BooleanArray(n + 1)
        var count = 0

        // 모든 수를 소수로 가정하고 초기화
        for (i in 2..n) {
            isPrime[i] = true
        }

        // 최적화 1: n의 제곱근까지만 반복
        val sqrtN = Math.sqrt(n.toDouble()).toInt()
        for (i in 2..sqrtN) {
            if (isPrime[i]) {
                var j = i * i
                while (j <= n) {
                    isPrime[j] = false
                    j += i
                }
            }
        }

        // 소수 개수 세기
        for (i in 2..n) {
            if (isPrime[i]) {
                count++
            }
        }

        return count
    }
}