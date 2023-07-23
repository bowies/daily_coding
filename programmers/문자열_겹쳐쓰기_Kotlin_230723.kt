package programmers

class 문자열_겹쳐쓰기_Kotlin_230723 {

    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        // Kotlin에서는 var 또는 val 키워드를 사용하여 변수를 선언합니다.
        // 여기서는 answer 변수를 생략하고 바로 결과 문자열을 반환합니다.
        return my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length)
    }

    fun solution2(my_string: String, overwrite_string: String, s: Int): String {
        val answer = my_string.substring(0, s) +
                overwrite_string +
                my_string.substring(s + overwrite_string.length)

        return answer
    }

    fun solution_short(myString: String, overwriteString: String, s: Int): String =
        myString.replaceRange(s, s + overwriteString.length, overwriteString)

    /*

    위의 코드는 Kotlin의 확장 함수인 `replaceRange`을 이용하여 문자열을 일부분 수정하는 방법을 보여줍니다.
    이 함수는 주어진 범위 내의 문자열을 다른 문자열로 대체하는 기능을 제공합니다.

    **함수 설명:**

    `fun solution_short(myString: String, overwriteString: String, s: Int): String`

    이 함수는 세 개의 매개변수를 받아들입니다:
    - `myString`: 원본 문자열입니다.
    - `overwriteString`: 대체할 새로운 문자열입니다.
    - `s`: 대체할 부분의 시작 인덱스입니다.

        이 함수의 목적은 `myString` 문자열에서 인덱스 `s`로부터 `overwriteString`의 길이만큼의 부분을 `overwriteString`으로 대체한 새로운 문자열을 반환하는 것입니다.

    **함수 내용:**

    ```
        myString.replaceRange(s, s + overwriteString.length, overwriteString)
    ```

    위 코드는 `replaceRange` 확장 함수를 사용하여 대체 작업을 수행합니다.
    `replaceRange` 함수는 `myString` 문자열에서 `s` 인덱스부터
    `s + overwriteString.length` 인덱스까지의 부분 문자열을
    `overwriteString`으로 대체합니다. 이후 새로운 문자열을 반환합니다.

    따라서, 주어진 함수 `solution_short`는 `myString`의 특정 부분을
    `overwriteString`으로 대체한 새로운 문자열을 반환하는 함수입니다.
    이렇게 작성된 코드는 간결하고 가독성이 높아져 유지보수가 용이하며,
    함수 `replaceRange`의 기능을 활용하여 문자열 조작을 효율적으로 수행합니다.

     */

}