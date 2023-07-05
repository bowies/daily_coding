package programmers

class n보다_커질_때까지_더하기_Kotlin_230705 {


    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0

        for (i in 0 until numbers.size) {
            answer += numbers[i]
            if (answer > n) {
                break
            }
        }

        return answer
    }

    fun solution_short(numbers: IntArray, n: Int) =
        numbers
            .fold(0)
                { sum, i
                    ->
                        if
                            (n >= sum)
                                sum + i
                        else
                            sum }

    /*

        1. `solution` 메서드:
           - 주어진 `numbers` 배열의 모든 요소를 반복하면서 덧셈을 수행합니다.
           - `answer` 변수에 현재 요소를 더합니다.
           - 만약 `answer`가 `n`보다 크면 반복을 종료합니다.
           - 최종적으로 `answer` 값을 반환합니다.

        2. `solution_short` 메서드:
           - `fold` 함수를 사용하여 배열의 요소를 누적 합산합니다.
           - `fold` 함수의 첫 번째 인자로 초기값 `0`을 전달합니다.
           - `fold` 함수의 두 번째 인자는 누적된 합계(`sum`)와 현재 요소(`i`)를 받아서 다음 합계를 계산하는 람다 함수입니다.
           - 람다 함수 내에서 현재 합계 `sum`와 `n`을 비교하여 `n`보다 작거나 같으면 현재 요소를 더하고, 그렇지 않으면 현재 합계를 그대로 유지합니다.
           - 최종적으로 `fold` 함수의 결과인 최종 합계를 반환합니다.

        두 메서드 모두 같은 문제를 해결하는데 사용되는 방법이 다릅니다.
        `solution` 메서드는 반복문을 사용하여 요소를 더하고 조건을 체크하는 방식이며,
        `solution_short` 메서드는 `fold` 함수를 사용하여 누적 합산과 조건 체크를 처리하는 방식입니다.
        `solution_short` 메서드는 코드가 간결해지고 함수형 프로그래밍 스타일을 적용한 것으로 볼 수 있습니다.
     */

}