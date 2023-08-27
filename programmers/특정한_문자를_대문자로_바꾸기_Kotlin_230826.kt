package programmers

class 특정한_문자를_대문자로_바꾸기_Kotlin_230826 {
    fun solution(my_string: String, alp: String): String {
        var answer: String = ""
        return my_string.replace(alp, alp.uppercase())
    }

    fun solution2(myString: String, alp: String): String {
        return myString.replace(alp, alp.uppercase())
    }
}