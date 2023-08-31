package programmers

import java.util.stream.Collectors

class 꼬리_문자열_Kotlin_230831 {
    fun solution(strList: Array<String>, ex: String): String {
        val answer = StringBuilder()
        for (str in strList) {
            answer.append(if (str.contains(ex)) "" else str)
        }
        return answer.toString()
    }

    fun solutionStream(strList: Array<String>, ex: String): String {
        return strList.filter { !it.contains(ex) }
            .joinToString("")
    }
}
