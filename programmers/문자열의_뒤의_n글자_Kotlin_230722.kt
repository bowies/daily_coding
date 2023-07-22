package programmers

class 문자열의_뒤의_n글자_Kotlin_230722 {
    fun solution(my_string: String, n: Int): String {
        val answer = my_string.substring(my_string.length - n, my_string.length)
        return answer
    }


    fun solution2(my_string: String, n: Int): String {
        val index = my_string.length - n
        return my_string.substring(index)
    }


    fun solution_stream(my_string: String, n: Int): String {
        // 문자열의 뒤에서 n개의 글자를 추출할 인덱스 범위를 생성합니다.
        // until을 사용하여 my_string.length - n 이상 my_string.length 미만의 범위를 생성합니다.
        val indexRange = my_string.length - n until my_string.length

        // map 함수를 사용하여 각 인덱스 위치의 문자들을 가져와서 List<Character>로 만듭니다.
        // Kotlin의 문자열은 자바와 다르게 []를 사용하여 간단하게 인덱스로 접근할 수 있습니다.
        val characters = indexRange.map { my_string[it] }

        // joinToString 함수를 사용하여 List<Character>를 하나의 문자열로 합칩니다.
        // joinToString은 컬렉션의 요소를 하나의 문자열로 연결하는 메서드입니다.
        // 여기서는 빈 문자열("")로 연결하여 하나의 문자열로 만듭니다.
        return characters.joinToString("")

        /*

        1. `val indexRange = my_string.length - n until my_string.length`
           - 문자열 `my_string`의 길이에서 `n`을 빼고, `until` 키워드를 사용하여 해당 값 이상부터 `my_string.length` 미만까지의 범위를 생성합니다. 즉, 뒤에서 `n`개의 글자를 추출할 인덱스 범위를 생성합니다.

        2. `val characters = indexRange.map { my_string[it] }`
           - `map` 함수를 사용하여 `indexRange`의 각 인덱스 위치에 대응하는 문자를 가져와서 새로운 List로 만듭니다. `it`는 `map` 함수의 파라미터로 사용되며, 각 인덱스를 의미합니다. 따라서 `my_string[it]`는 `indexRange`의 각 인덱스에 해당하는 문자를 의미합니다.

        3. `return characters.joinToString("")`
           - `joinToString` 함수를 사용하여 `characters` 리스트를 하나의 문자열로 합칩니다. `joinToString` 함수는 컬렉션의 요소들을 하나의 문자열로 연결하는 메서드입니다. 여기서는 빈 문자열("")을 구분자로 사용하여 리스트의 모든 문자를 하나의 문자열로 만듭니다.

        따라서 `solutionStream` 메서드는 문자열 `my_string`에서 뒤에서 `n`개의 글자를 추출하여 하나의 문자열로 반환하는 Kotlin 코드입니다.
         */
    }

}