package programmers

class qr_code_Kotlin_230812 {
    /*
        두 정수 q, r과 문자열 code가 주어질 때,
        code의 각 인덱스를 q로 나누었을 때
        나머지가 r인 위치의 문자를 앞에서부터
        순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
     */
    fun solution(q: Int, r: Int, code: String): String {
        val answer = StringBuilder()

        for (i in code.indices) { //인덱스 접근하려면 indices 속성 씀
            if (i % q == r) {
                answer.append(code[i])
            }
        }

        return answer.toString()
    }

    fun solution_stream(q: Int, r: Int, code: String): String {
        return code.indices
            .filter { it % q == r }
            .map { code[it] }
            .joinToString("")
    }

    fun solution_best(q: Int, r: Int, code: String): String =
        code.filterIndexed { i, _ -> i % q == r }

}
