package programmers

class 공백으로_구분하기_2_Kotlin_230903 {
    fun solution(my_string: String): Array<String> {
        return my_string.trim().split(Regex("[ ]+")).toTypedArray()
    }


    fun solution_best(myString: String): List<String> {
        //공백문자 = \\s
        return myString.trim().split("\\s+".toRegex())
    }
}