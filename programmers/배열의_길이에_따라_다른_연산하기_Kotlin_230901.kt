package programmers

import java.util.stream.IntStream

class 배열의_길이에_따라_다른_연산하기_Kotlin_230901 {

    fun solution(arr: IntArray, n: Int): IntArray {
        if (arr.size % 2 == 0) {
            for (i in arr.indices) {
                if (i % 2 != 0) {
                    arr[i] += n
                }
            }
        } else {
            for (i in arr.indices) {
                if (i % 2 != 1) {
                    arr[i] += n
                }
            }
        }
        return arr
    }


    fun solution_short(arr: IntArray, n: Int): List<Int> {
        return arr.indices.map { arr[it] + if (it % 2 == (if (arr.size % 2 == 0) 1 else 0)) n else 0 }
    }

}
