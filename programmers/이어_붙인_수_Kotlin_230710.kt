package programmers

class 이어_붙인_수_Kotlin_230710 {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0

        var 홀수 = ""
        var 짝수 = ""

        for (i in num_list.indices) {
            if (num_list[i] % 2 == 0) {
                짝수 += num_list[i].toString()
            } else {
                홀수 += num_list[i].toString()
            }
        }

        answer = 홀수.toInt() + 짝수.toInt()

        return answer
    }


    fun solution_stream(num_list: IntArray): Int {
        val 홀수 = num_list.filter { it % 2 != 0 }.joinToString("")
        val 짝수 = num_list.filter { it % 2 == 0 }.joinToString("")
        //joinToString(""): 필터링하여 문자열로 변환합니다.

        return 홀수.toInt() + 짝수.toInt()
    }

    fun solution_stream_help(numList: IntArray): Int =
        numList
            .partition { it % 2 == 0 }
            .toList()
            .sumOf { it
                        .joinToString("")
                        .toInt()
                    }

    /*

    1. `fun solution_stream_help(numList: IntArray): Int = ...`:
        `solution_stream_help` 함수를 선언합니다.
        `numList`라는 이름의 `Int` 배열을 인자로 받고,
        `Int` 값을 반환합니다. 화살표(`=`)를 사용하여 함수의 본문을 정의합니다.

    2. `numList.partition { it % 2 == 0 }`:
        `numList` 배열을 홀수와 짝수로 분할합니다.
        `partition` 함수는 주어진 조건에 따라 요소를 두 그룹으로 나누고, 그 결과를 `Pair`로 반환합니다.

    3. `.toList()`:
        `partition` 함수의 결과를 `List`로 변환합니다.
        이때, `Pair` 객체의 첫 번째 요소는 홀수 그룹이며, 두 번째 요소는 짝수 그룹입니다.

    4. `.sumOf { it.joinToString("").toInt() }`:
        변환된 `List`의 각 요소를 문자열로 변환하고, 이를 정수로 변환한 후 그 합을 계산합니다.
        `sumOf` 함수는 각 요소를 변환한 후 합을 계산하는 함수입니다.

    위의 코드는 `stream`을 사용하여 배열을 홀수와 짝수로 분할하고,
    그룹별로 문자열로 변환한 후 합을 계산합니다.
    이를 통해 간결하고 함수형적인 코드를 작성할 수 있습니다.
     */
}