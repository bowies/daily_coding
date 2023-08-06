package programmers

class 공백으로_구분하기_1_Kotlin_230804 {

    fun solution(my_string: String): Array<String> {
        return my_string.split(" ").toTypedArray()
    }

    fun solution2(my_string: String) = my_string.split(" ")

}