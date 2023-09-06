package programmers
class 문자열_붙여서_출력하기_Kotlin_230906 {
    fun solution(args: Array<String>) {
        val input = readLine()!!.split(' ')
        val s1 = input[0]
        val s2 = input[1]

        val s3 = (s1 + s2).trim();
        println(s3)
    }
}