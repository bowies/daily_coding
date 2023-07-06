package programmers

class 홀짝_구분하기_Kotlin_230706 {
    fun main(args: Array<String>) {
        val n = readLine()!!.toInt()

        var result =
            if(n%2 == 0){
                "even"
            }else{
                "odd"
            }

        println("$n is $result")
    }

    fun 삼항연산자(args: Array<String>) {
        val n = readLine()!!.toInt()

        println("$n is ${if(n%2 == 0) "even" else "odd"}")
    }
}