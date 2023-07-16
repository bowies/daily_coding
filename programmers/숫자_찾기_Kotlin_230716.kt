package programmers
class 숫자_찾기_Kotlin_230716 {
    /*
        정수 num과 k가 매개변수로 주어질 때,
        num을 이루는 숫자 중에 k가
        있으면 num의 그 숫자가 있는 자리 수를 return하고
        없으면 -1을 return 하도록 solution 함수를 완성해보세요.
     */

    // 반복문을 사용하여 숫자를 검색하는 방식으로 구현
    fun solution(num: Int, k: Int): Int {
        val numString = num.toString()

        for (i in numString.indices) { // numString의 인덱스를 순회합니다.
            if (numString[i] == k.toString()[0]) { // 현재 인덱스의 숫자와 k를 비교합니다.
                return i + 1 // 일치하는 숫자가 있으면 인덱스에 1을 더하여 반환합니다.
            }
        }

        return -1 // 일치하는 숫자가 없으면 -1을 반환합니다.
    }

    // 스트림을 사용하여 숫자를 검색하는 방식으로 구현
    fun solution_stream(num: Int, k: Int): Int {
        val numString = num.toString()
        val chr = k.toString()[0]

        return numString.indices
            .firstOrNull { numString[it] == chr } // numString에서 chr과 일치하는 첫 번째 인덱스를 찾습니다.
            ?.let { it + 1 } // 일치하는 값이 있으면 인덱스에 1을 더하여 반환합니다.
            ?: -1 // 일치하는 값이 없으면 -1을 반환합니다.
    }

    // 문자열 연산을 사용하여 숫자를 검색하는 방식으로 구현
    fun solution_short(num: Int, k: Int): Int {
        return ("-".plus(num)).indexOf(k.toString())
        // num 앞에 "-"를 추가하여 음수 처리 후 k의 첫 번째 등장 위치를 찾습니다.
    }

    // 문자열 연산을 사용하여 숫자를 검색하는 방식으로 구현 (간소화된 버전)
    fun solution_short2(num: Int, k: Int) = "-$num".indexOf(k.toString())
    // num 앞에 "-"를 추가하여 음수 처리 후 k의 첫 번째 등장 위치를 찾습니다.
}
