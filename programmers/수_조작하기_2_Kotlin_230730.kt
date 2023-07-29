package programmers

import java.util.stream.Collectors
import java.util.stream.IntStream

class 수_조작하기_2_Kotlin_230730 {
    /*
    정수 배열 numLog가 주어집니다.
    처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.

    "w" : 수에 1을 더한다.
    "s" : 수에 1을 뺀다.
    "d" : 수에 10을 더한다.
    "a" : 수에 10을 뺀다.
    그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다.
    즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.

    주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return하는 solution 함수를 완성해 주세요.

    입출력 예
    numLog	result
    [0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1]	"wsdawsdassw"
     */

    // 일반적인 방식으로 조작하는 메서드
    fun solution(numLog: IntArray): String {
        val sb = StringBuilder()

        // 두 번째 원소부터 루프를 시작합니다. (첫 번째 원소는 루프에 포함하지 않음)
        for (i in 1 until numLog.size) {
            // 현재 원소와 이전 원소의 차이를 계산합니다.
            val 입력된문자열 = numLog[i] - numLog[i - 1]
            // 조작에 따라 "w", "s", "d", "a"를 StringBuilder에 추가합니다.
            when (입력된문자열) {
                1 -> sb.append("w")
                -1 -> sb.append("s")
                10 -> sb.append("d")
                -10 -> sb.append("a")
            }
        }

        // StringBuilder를 문자열로 변환하여 반환합니다.
        return sb.toString()
    }

    // 스트림을 사용하여 조작하는 메서드
    fun solution_stream(numLog: IntArray): String {
        // IntStream을 사용하여 1부터 배열의 마지막 인덱스까지의 범위를 생성합니다.
        return IntStream.range(1, numLog.size)
            // mapToObj를 사용하여 각 인덱스에 대해 조작 결과를 문자열로 매핑합니다.
            .mapToObj { i ->
                // 현재 원소와 이전 원소의 차이를 계산합니다.
                val 입력된문자열 = numLog[i] - numLog[i - 1]
                // 조작에 따라 "w", "s", "d", "a" 중 하나를 반환합니다.
                when (입력된문자열) {
                    1 -> "w"
                    -1 -> "s"
                    10 -> "d"
                    -10 -> "a"
                    else -> "" // 해당하는 조작이 없으면 빈 문자열을 반환합니다.
                }
            }
            // 각 문자열을 합쳐서 하나의 문자열로 만듭니다.
            .collect(Collectors.joining())
    }

    // 더 간단한 스트림을 사용하여 조작하는 메서드
    fun solution_short(numLog: IntArray): String {
        // 1부터 배열의 마지막 인덱스까지의 범위를 생성하고, map을 사용하여 각 인덱스에 대해 조작 결과를 문자로 매핑한 뒤
        // joinToString을 사용하여 결과 문자들을 하나의 문자열로 합칩니다.
        return (1..numLog.lastIndex).map {
            // 현재 원소와 이전 원소의 차이를 계산하고 조작에 따라 "w", "s", "d", "a" 중 하나의 문자를 반환합니다.
            when (numLog[it] - numLog[it - 1]) {
                1 -> 'w'
                -1 -> 's'
                10 -> 'd'
                else -> 'a' // 해당하는 조작이 없으면 'a'를 반환합니다.
            }
        }.joinToString("") // 각 문자들을 합쳐서 하나의 문자열로 만듭니다.
    }
}
