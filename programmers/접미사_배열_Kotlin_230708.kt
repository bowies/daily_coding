package programmers

class 접미사_배열_Kotlin_230708 {

    fun solution(my_string: String): Array<String> {
        val length = my_string.length
        val 접미사 = Array(length) { "" }

        for (i in 0 until length) {
            접미사[i] = my_string.substring(i)
        }

        접미사.sort()

        return 접미사
    }


    fun solution_stream(myString: String): Array<String> {
        return (0 until myString.length)
            .map { myString.substring(it) }
            .sorted()
            .toTypedArray()
    }

    fun solution_short(myString: String) = myString.indices.map(myString::substring).sorted()

    /*

    1. `solution` 메서드:
        - 주어진 문자열 `my_string`의 모든 접미사를 사전순으로 정렬하여 문자열 배열로 반환합니다.
        - `length` 변수에 `my_string`의 길이를 저장합니다.
        - `접미사`라는 이름의 문자열 배열을 생성하고, 길이는 `length`와 동일합니다.
        - `for` 루프를 사용하여 0부터 `length - 1`까지 반복합니다.
        - `substring(i)`를 사용하여 `my_string`의 현재 인덱스부터 끝까지의 부분 문자열을 구합니다.
        - 구한 부분 문자열을 `접미사` 배열의 해당 인덱스에 저장합니다.
        - `접미사` 배열을 사전순으로 정렬합니다.
        - 정렬된 `접미사` 배열을 반환합니다.

    2. `solution_stream` 메서드:
        - `solution` 메서드와 동일한 기능을 수행하지만, 스트림을 사용하여 구현합니다.
        - `(0 until myString.length)` 범위를 생성하여 0부터 `myString`의 길이 - 1까지의 정수를 나타내는 범위를 만듭니다.
        - `map` 함수를 사용하여 각 인덱스를 해당 인덱스부터 끝까지의 부분 문자열로 변환합니다.
        - `sorted` 함수를 사용하여 접미사를 사전순으로 정렬합니다.
        - `toTypedArray` 함수를 사용하여 정렬된 스트림을 문자열 배열로 변환하여 반환합니다.

    3. `solution_short` 메서드:
        - `solution_stream` 메서드와 동일한 기능을 수행합니다.
        - 더 간결한 형태로 작성되었습니다.
        - `myString.indices.map(myString::substring)`을 사용하여 `myString`의 각 인덱스를 해당 인덱스부터 끝까지의 부분 문자열로 매핑합니다.
        - `sorted` 함수를 사용하여 접미사를 사전순으로 정렬합니다.
        - 정렬된 결과를 반환합니다.

     */
}