package programmers
import kotlin.math.*

class 더_크게_합치기_Kotlin_230721 {
    // 주어진 두 정수 a와 b를 합쳐서 만든 두 수의 크기를 비교하여 더 큰 값을 반환하는 함수입니다.
    fun solution(a: Int, b: Int): Int {
        // 두 정수 a와 b를 문자열로 변환한 후 합쳐서 새로운 문자열을 만듭니다.
        val ans1 = "$a$b".toInt()
        // 두 정수 b와 a를 문자열로 변환한 후 합쳐서 새로운 문자열을 만듭니다.
        val ans2 = "$b$a".toInt()

        // 두 수 중에서 큰 값을 반환합니다.
        return maxOf(ans1, ans2)
    }

    // 주어진 두 정수 a와 b를 합쳐서 만든 두 수의 크기를 비교하여 더 큰 값을 반환하는 함수입니다.
    fun solution2(a: Int, b: Int): Int {
        // 두 정수 a와 b를 문자열로 변환한 후 합쳐서 새로운 문자열을 만듭니다.
        val str1 = "$a$b"
        // 두 정수 b와 a를 문자열로 변환한 후 합쳐서 새로운 문자열을 만듭니다.
        val str2 = "$b$a"

        // 두 문자열을 정수로 변환하여 크기를 비교합니다.
        // 큰 값을 반환합니다.
        val answer = if (str1.toInt() > str2.toInt()) {
            str1.toInt()
        } else {
            str2.toInt()
        }

        return answer
    }

    // 주어진 두 정수 a와 b를 합쳐서 만든 두 수의 크기를 비교하여 더 큰 값을 반환하는 함수입니다.
    fun solution_short(a: Int, b: Int): Int {
        // 두 정수 a와 b를 문자열로 변환한 후 합쳐서 새로운 문자열을 만듭니다.
        // 두 문자열을 정수로 변환하여 크기를 비교하고, 큰 값을 반환합니다.
        return max("$a$b".toInt(), "$b$a".toInt())
    }
}
