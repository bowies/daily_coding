package programmers
class 암호_해독_Kotlin_230715 {

    /**
     * 주어진 암호(cipher) 문자열에서 code의 배수 번째 글자만 추출하여 반환합니다.
     *
     * @param cipher 암호화된 문자열
     * @param code   추출할 문자의 배수를 나타내는 값
     * @return 추출된 암호 문자열
     */
    fun solution(cipher: String, code: Int): String {
        var answer: String = ""

        // cipher 문자열의 각 문자에 대해 반복
        for (i in cipher.indices) {
            // (i + 1)이 code의 배수인 경우
            if ((i + 1) % code == 0) {
                // 현재 문자를 추출하여 answer에 추가
                answer += cipher[i]
            }
        }

        return answer
    }

    /**
     * 주어진 암호(cipher) 문자열에서 code의 배수 번째 글자만 추출하여 반환합니다.
     *
     * @param cipher 암호화된 문자열
     * @param code   추출할 문자의 배수를 나타내는 값
     * @return 추출된 암호 문자열
     */
    fun solution2(cipher: String, code: Int): String {
        val answer = StringBuilder()

        // code부터 시작하여 code의 배수 번째 글자만 answer에 추가
        for (i in code - 1 until cipher.length step code) {
            answer.append(cipher[i])
        }

        return answer.toString()
    }

    /**
     * 주어진 암호(cipher) 문자열에서 code의 배수 번째 글자만 추출하여 반환합니다. (Stream 사용)
     *
     * @param cipher 암호화된 문자열
     * @param code   추출할 문자의 배수를 나타내는 값
     * @return 추출된 암호 문자열
     */
    fun solution_stream(cipher: String, code: Int): String {
        return cipher.indices
            .filter { (it + 1) % code == 0 }  // code의 배수 번째 인덱스 필터링
            .map { cipher[it] }  // 해당 인덱스의 문자 추출
            .joinToString("")  // 문자열로 결합
    }

    /**
     * 주어진 암호(cipher) 문자열에서 code의 배수 번째 글자만 추출하여 반환합니다. (Stream 사용)
     *
     * @param cipher 암호화된 문자열
     * @param code   추출할 문자의 배수를 나타내는 값
     * @return 추출된 암호 문자열
     */
    fun solution_stream2(cipher: String, code: Int): String {
        return cipher.indices
            .filter { (it + 1) % code == 0 }  // code의 배수 번째 인덱스 필터링
            .map { cipher[it].toString() }  // 해당 인덱스의 문자를 문자열로 변환
            .joinToString("")  // 문자열로 결합
    }
}
