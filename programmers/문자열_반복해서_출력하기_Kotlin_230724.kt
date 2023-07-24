package programmers

class 문자열_반복해서_출력하기_Kotlin_230724 {
    fun main(args: Array<String>) {
        /*

        문자열 str과 정수 n이 주어집니다.
        str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
        */

        val input = readLine()!!.split(' ')
        val str = input[0]
        val n = input[1]!!.toInt()

        repeat(n) {
            print(str)
        }
    }
    fun main2(args: Array<String>) {

        val input = readLine()!!.split(' ')
        val str = input[0]
        val n = input[1]!!.toInt()

        println(str.repeat(n))

    }
    fun main3(args: Array<String>) {
        val input = readLine()!!.split(' ')
        val str = input[0]
        val n = input[1]!!.toInt()

        for (i in 0 until n) {
            print(str)
        }
    }
}