package programmers

class 원소들의_곱과_합_Kotlin_230805 {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0

        var 곱= 1
        var 합 = 0

        for (i in num_list) {
            합 += i
            곱 *= i
        }
        if (곱 < 합 * 합) {
            answer = 1
        }

        return answer
    }

    fun solution_stream(num_list: IntArray): Int {
        val 곱 = num_list.reduce { x, y -> x * y }
        val 합 = num_list.sum()

        return if (곱 < 합 * 합) {
            1
        } else {
            0
        }
    }
}