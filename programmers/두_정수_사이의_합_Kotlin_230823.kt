package programmers

class 두_정수_사이의_합_Kotlin_230823 {
    /*
        두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
        예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
     */
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0

        for (i in minOf(a, b)..maxOf(a, b)) {
            answer += i
        }

        return answer
    }

    fun solution_best(a: Int, b: Int): Long {
        // 등차수열의 합!!!!
        return sumAtoB(minOf(a, b).toLong(), maxOf(a, b).toLong())
    }

    private fun sumAtoB(a: Long, b: Long): Long {
        return (b - a + 1) * (a + b) / 2
    }
}
