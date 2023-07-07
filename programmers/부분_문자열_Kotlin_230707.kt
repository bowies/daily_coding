package programmers

class 부분_문자열_Kotlin_230707 {

    fun solution(str1: String, str2: String): Int {
        var answer: Int = 0
        if (str2.contains(str1))
            answer = 1
        else
            answer = 0
        return answer;

    }

    fun solution_short(str1: String, str2: String): Int {
        return if (str2.contains(str1)) 1 else 0
    }
}