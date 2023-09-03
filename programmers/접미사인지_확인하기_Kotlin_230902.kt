package programmers

class 접미사인지_확인하기_Kotlin_230902 {
    fun solution(my_string: String, is_suffix: String): Int {
        return if (my_string.endsWith(is_suffix)) {
            1
        } else {
            0
        }

    }
    fun solution_same(myString: String, is_suffix: String) = if (myString.endsWith(is_suffix)) 1 else 0


}
