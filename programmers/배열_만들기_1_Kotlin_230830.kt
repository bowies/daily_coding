package programmers;

class Solution {


    fun solution(n: Int, k: Int): IntArray {
        val answer = IntArray(n / k)

        for (i in 0 until n / k) {
            answer[i] = (i + 1) * k
        }

        return answer
    }

    fun solution2(n: Int, k: Int): IntArray {
        val length = n / k

        val answer = mutableListOf<Int>()

        for (i in 1..length) {
            answer.add(i * k)
        }

        return answer.toIntArray()
    }

    fun solution_short(n: Int, k: Int) = (k..n step k).toList() 
    // k부터 시작해서 k씩 증가하도록 step 을 씀 
    // n이 10이고 k가 2면 2 - 4 - 6 - 8 - 10 으로 증가
}
