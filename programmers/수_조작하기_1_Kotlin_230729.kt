package programmers
class 수_조작하기_1_Kotlin_230729 {
    /*
    정수 n과 문자열 control이 주어집니다.
    control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며,
    control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

    "w" : n이 1 커집니다.
    "s" : n이 1 작아집니다.
    "d" : n이 10 커집니다.
    "a" : n이 10 작아집니다.
    위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
     */
    fun solution(n: Int, control: String): Int {
        var answer = n

        for (i in 0 until control.length) {
            when (control[i]) {
                'w' -> answer++
                's' -> answer--
                'd' -> answer += 10
                'a' -> answer -= 10
            }
        }

        return answer
    }

    fun solution2(n: Int, control: String): Int {
        var answer = n

        for (i in 0 until control.length) {
            val ch = control[i]
            when (ch) {
                'w' -> answer++
                's' -> answer--
                'd' -> answer += 10
                'a' -> answer -= 10
            }
        }

        return answer
    }

    fun solution3(n: Int, control: String): Int {
        val operationMap = mapOf(
            'w' to 1,
            's' to -1,
            'd' to 10,
            'a' to -10
        )

        var answer = n

        for (i in 0 until control.length) {
            val ch = control[i]
            if (operationMap.containsKey(ch)) {
                answer += operationMap[ch]!!
            }
        }

        return answer
    }

    fun solution4(n: Int, control: String): Int {
        // control.toCharArray()는 control 문자열을 CharArray로 변환합니다.
        // reduce 메서드는 배열의 요소를 줄여가면서 연산을 수행합니다.
        // 여기서 acc는 누적된 값이고, c는 현재 처리중인 문자입니다.
        return control.toCharArray().fold(n) { answer, i ->
            // when 식을 사용하여 i의 값에 따라 answer 값을 조작합니다.
            when (i) {
                'w' -> answer + 1
                's' -> answer - 1
                'd' -> answer + 10
                'a' -> answer - 10
                else -> answer
            }
        }
    }



    fun solution_short(n: Int, control: String): Int {
        // control.fold(n)은 control 문자열을 접습니다. fold 함수는 초기값 n으로 시작하여 각 문자 i에 대해
        // 지정된 연산을 수행하고 최종 결과를 반환합니다.
        return control.fold(n) { answer, i ->
            // if-else 식을 사용하여 c의 값에 따라 acc 값을 조작합니다.
            // 'w'일 경우 1을 더하고, 's'일 경우 1을 빼고, 'd'일 경우 10을 더하고, 'a'일 경우 10을 뺍니다.
            // 해당하는 조건이 없을 경우 기본적으로 -10을 더합니다.
            answer + if (i == 'w') 1 else if (i == 's') -1 else if (i == 'd') 10 else -10
        }
    }

}
