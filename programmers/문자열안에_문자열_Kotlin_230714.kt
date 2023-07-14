package programmers

class 문자열안에_문자열_Kotlin_230714 {

    /*
        문자열 str1, str2가 매개변수로 주어집니다.
        str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.
     */
    fun solution(str1: String, str2: String): Int {
        var answer: Int = 2

        if (str1.contains(str2)) {
            answer = 1
        }

        return answer
    }

    fun solution_stream(str1: String, str2: String): Int {
        return if (str1.contains(str2)) 1 else 2
    }


}