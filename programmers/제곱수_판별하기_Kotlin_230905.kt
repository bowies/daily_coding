package programmers

import java.lang.Math.sqrt

class 제곱수_판별하기_Kotlin_230905{
    /*
        어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
        정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.


     */
    fun solution(n: Int): Int {
        var answer: Int = 0

        for (i in 1..n) {
            if (i * i == n) {
                answer = 1
                break
            } else {
                answer = 2
            }
        }

        return answer
    }


    fun solution_sqrt(n: Int): Int {
        val sqrt = sqrt(n.toDouble()).toLong()
        return if(sqrt*sqrt == n.toLong()) 1 else 2
    }
}