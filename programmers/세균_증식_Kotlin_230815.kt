package programmers

class 세균_증식_Kotlin_230815 {

    fun solution(n: Int, t: Int): Int {
        var answer = n

        for (index in 0..t - 1)
            answer *= 2

        return answer
    }
    fun solution_best(n: Int, t: Int): Int = n shl t

}