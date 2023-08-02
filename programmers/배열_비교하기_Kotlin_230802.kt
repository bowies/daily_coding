package programmers

class 배열_비교하기_Kotlin_230802 {
    fun solution(arr1: IntArray, arr2: IntArray): Int {

        val sum1 = arr1.sum()
        val sum2 = arr2.sum()

        return when {
            arr1.size != arr2.size -> arr1.size.compareTo(arr2.size)
            else -> sum1.compareTo(sum2)
        }
    }


    fun solution2(arr1: IntArray, arr2: IntArray): Int {
        val answer = if (arr1.size != arr2.size) {
            if (arr1.size > arr2.size) 1 else -1
        } else {
            arr1.sum().compareTo(arr2.sum())
        }
        return answer
    }
}