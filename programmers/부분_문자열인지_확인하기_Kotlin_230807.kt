package programmers

class 부분_문자열인지_확인하기_Kotlin_230807 {
    fun solution(my_string: String, target: String): Int {
        var answer: Int = 0
        return if (target in my_string) 1 else 0
    }

    fun solution_short(myString: String, target: String) = if (myString.contains(target)) 1 else 0

}