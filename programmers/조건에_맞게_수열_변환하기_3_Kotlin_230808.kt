package programmers

class 조건에_맞게_수열_변환하기_3_Kotlin_230808 {
    fun solution(arr: IntArray, k: Int): IntArray {
        return if (k % 2 == 0) {
            arr.map { it + k }.toIntArray()
        } else {
            arr.map { it * k }.toIntArray()
        }
    }

    fun solution2(arr: IntArray, k: Int): IntArray {
        if (k % 2 == 0) {
            for (i in arr.indices) {
                arr[i] += k
            }
        } else {
            for (i in arr.indices) {
                arr[i] *= k
            }
        }
        return arr
    }


    fun solution_short(arr: IntArray, k: Int) = arr.map { if (k % 2 == 0) it + k else it * k }

}
