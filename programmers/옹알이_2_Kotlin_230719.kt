package programmers

class 옹알이_2_Kotlin_230719 {

    /**
     * 주어진 문자열 배열에서 발음 가능한 단어의 개수를 반환하는 함수입니다.
     *
     * @param babbling 문자열 배열
     * @return 발음 가능한 단어의 개수
     */
    fun solution(babbling: Array<String>): Int {

        var answer: Int = 0

        // 주어진 배열의 각 단어에 대해 발음 가능 여부를 확인합니다.
        for (word in babbling) {
            if (발음가능(word)) {
                answer++
            }
        }

        return answer
    }

    /**
     * 주어진 단어가 발음 가능한지 여부를 판단하는 함수입니다.
     *
     * @param word 단어
     * @return 발음 가능 여부 (true: 발음 가능, false: 발음 불가능)
     */
    private fun 발음가능(word: String): Boolean {

        // 발음 가능한 문자열 패턴을 저장한 배열입니다.
        val 조카 = arrayOf("aya", "ye", "woo", "ma")

        // 단어를 수정하기 위해 임시로 저장하는 변수입니다.
        var modifiedWord = word

        // 발음 가능한 문자열 패턴을 해당 인덱스로 대체합니다.
        for (i in 조카.indices) {
            modifiedWord = modifiedWord.replace(조카[i], i.toString())
        }

        // 연속된 숫자가 없는지 검사하고 발음 가능 여부를 결정합니다.
        var prev = '-'
        for (i in modifiedWord.indices) {
            val curr = modifiedWord[i]
            if (curr < '0' || curr > '3') {
                return false
            }
            if (prev == curr) {
                return false
            }
            prev = curr
        }

        return true
    }

    /**
     * 개선된 해결 방법을 제시한 함수입니다.
     *
     * @param babbling 문자열 배열
     * @return 발음 가능한 단어의 개수
     */
    fun solution_best(babbling: Array<String>): Int {
        var answer: Int = 0

        // 정규식 패턴을 사용하여 발음 가능한 단어를 필터링합니다.
        var regex = "aya|ye|woo|ma".toRegex()
        var regexC = "ayaaya|yeye|woowoo|mama".toRegex()
        answer = babbling
            .map { it.replace(regexC, "*") } // "ayaaya", "yeye", "woowoo", "mama"을 "*"로 대체합니다.
            .map { it.replace(regex, "") } // "aya", "ye", "woo", "ma"를 제거합니다.
            .filter { it == "" } // 빈 문자열인 경우만 필터링합니다.
            .size // 필터링된 개수를 반환합니다.

        return answer
    }

    /**
     * 더 간결한 방법으로 해결한 함수입니다.
     *
     * @param babbling 문자열 배열
     * @return 발음 가능한 단어의 개수
     */
    fun solution_shorts(babbling: Array<String>) = babbling.count {
        it.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$".toRegex())
    }
    /*
        위의 코드에서 `babbling.count`는 주어진 배열 `babbling`의 각 요소에 대해 특정 조건을 만족하는 요소의 개수를 세는 작업을 수행합니다.

        `it.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$".toRegex())`는 각 요소 `it`에 대해 정규식 패턴을 사용하여 발음 가능한 단어인지 확인하는 작업을 수행합니다.

        - `^`는 문자열의 시작을 의미합니다.
        - `(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))`는 발음 가능한 단어 패턴을 나타냅니다. 각각 "aya", "ye", "woo", "ma"를 나타내며, 각각의 뒤에는 같은 패턴이 오지 않아야 합니다.
        - `+`는 앞의 패턴이 하나 이상 반복되는 것을 의미합니다.
        - `"$"`는 문자열의 끝을 의미합니다.

        따라서, `it.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$".toRegex())`는 주어진 문자열 `it`가 "aya", "ye", "woo", "ma" 중 하나로 시작하며, 같은 패턴이 연속해서 나오지 않는 경우를 검사합니다.
        결과적으로, `babbling.count`는 주어진 배열에서 발음 가능한 단어의 개수를 반환합니다.
     */

}
