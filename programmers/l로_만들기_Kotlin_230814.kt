package programmers

class l로_만들기_Kotlin_230814 {
    fun solution(myString: String): String {
        return myString.map {
                if (it.code <= 'l'.code)
                    'l'
                else
                    it
            }
            .joinToString("")
    }


    fun solution2(myString: String): String {
        var answer: String = ""

        for (i in myString) {
            answer += if (i < 'l') {
                'l'
            } else {
                i
            }
        }
        return answer
    }
}