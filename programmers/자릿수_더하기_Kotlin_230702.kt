package programmers

class 자릿수_더하기_Kotlin_230702 {
    /*
        정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
     */
    fun solution(n: Int): Int {

        var answer: Int = 0
        var num = n

        while (num > 0) {
            answer += num % 10
            num /= 10
        }

        return answer
    }


    fun solution_short(n: Int): Int = n.toString().toList().sumOf { it.digitToInt() }

    /*

    1. `solution(n: Int): Int` 함수:
    이 함수는 정수 `n`의 각 자리 숫자의 합을 계산하여 반환하는 기능을 수행합니다.

    - `answer` 변수는 초기값 0으로 선언됩니다. 이 변수는 각 자리 숫자의 합을 저장하는 역할을 합니다.
    - `num` 변수는 `n`의 값으로 초기화됩니다. `num` 변수는 반복문에서 사용되며, `n`의 각 자릿수를 하나씩 추출하기 위해 사용됩니다.
    - `while` 루프는 `num`이 0보다 클 때까지 반복됩니다. 이는 `num`이 0이 되면 더 이상 자릿수가 남지 않을 때까지 반복합니다.
    - `num % 10`은 `num`의 마지막 자릿수를 구합니다. 이를 `answer`에 더해줍니다.
    - `num`을 10으로 나눠 다음 자릿수로 이동합니다.
    - 반복이 종료되면 `answer` 변수에는 `n`의 각 자리 숫자의 합이 저장되어 있으며, 이를 반환합니다.

    2. `solution_short(n: Int): Int` 함수:
    이 함수는 정수 `n`의 각 자리 숫자의 합을 계산하여 반환하는 기능을 수행합니다. 이 함수는 한 줄의 간결한 표현을 사용하여 작성되었습니다.

    - `n.toString()`은 정수 `n`을 문자열로 변환합니다.
    - `toList()`는 문자열을 문자 리스트로 변환합니다. 예를 들어, "123"은 ['1', '2', '3']으로 변환됩니다.
    - `sumOf { it.digitToInt() }`는 문자 리스트의 각 요소를 숫자로 변환하고, 변환된 숫자들의 합을 계산합니다.
    - 계산된 합을 반환합니다.

     */
}