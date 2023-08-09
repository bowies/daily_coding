package programmers

class 없는_숫자_더하기_Kotlin_230809 {
    fun solution(numbers: IntArray): Int  = 45 - numbers.sum()


    fun solution_short(numbers: IntArray): Int = (0..9).filterNot(numbers::contains).sum()
    //https://blog.yena.io/studynote/2020/01/22/Kotlin-Collection-Filter.html
    //filterNot은 말 그대로 조건이 아닌 경우에만 남길 때 사용하는 함수이다.
    //와... 함수를 좀 외워야겠다...

}