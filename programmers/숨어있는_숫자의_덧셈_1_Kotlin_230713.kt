package programmers

class 숨어있는_숫자의_덧셈_1_Kotlin_230713 {

    fun solution(my_string: String): Int {
        var answer = 0

        for (i in my_string.indices) {
            // 숫자면 answer에 더해줌
            if (Character.isDigit(my_string[i])) {
                answer += my_string[i] - '0'
            }
        }

        return answer
    }


    fun solution_stream(my_string: String): Int {

        return my_string.chars()                    // 문자열을 IntStream으로 변환합니다.
            .filter(Character::isDigit)             // 숫자인지 여부를 필터링합니다.
            .map(Character::getNumericValue)        // 문자를 정수로 변환합니다.
            .sum()                                  // 정수들의 합계를 구합니다.
    }


    fun solution_stream2(my_string: String): Int {
        return my_string.toCharArray().asSequence()     // 문자열을 문자 배열로 변환하고 시퀀스로 변환합니다.
            .filter { it.isDigit() }                    // 숫자인지 여부를 필터링합니다.
            .map { it.toString() }                      // 문자를 문자열로 변환합니다.
            .map { it.toInt() }                         // 문자열을 정수로 변환합니다.
            .sum()                                      // 정수들의 합계를 구합니다.
    }

    fun solution_short(my_string: String) =
        my_string
            .filter(Char::isDigit)
            .map { it -> it.toString().toInt() } // it -> it으로 생략 가능합니다. solution_short2 처럼 쓰면 됩니다.
            .sum()

    fun solution_short2(my_string: String) =
        my_string
            .filter(Char::isDigit)                      // 숫자인지 여부를 필터링합니다.
            .map { it.toString().toInt() }              // 문자를 문자열로 변환한 후 정수로 변환합니다.
            .sum()                                      // 정수들의 합계를 구합니다.

}