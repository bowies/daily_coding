package programmers

class 문자열_곱하기_Kotlin_230811 {

    fun solution_pojo(my_string: String, k: Int): String {
        var answer: String = ""
        for(i in 0 until k) {
            answer += my_string
        }
        return answer
    }

    fun solution_java11(my_string: String, k: Int): String {
        return my_string.repeat(k)
    }

    fun solution_stream(my_string: String, k: Int): String {
        return (0 until k)
            .map { my_string }
            .joinToString("")
    }

}