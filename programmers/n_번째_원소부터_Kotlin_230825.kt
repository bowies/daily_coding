package programmers

class n_번째_원소부터_Kotlin_230825 {

    fun solution(nums: IntArray, n: Int) = nums.slice(n - 1 until nums.size).toIntArray()

    fun solution2(numList: IntArray, n: Int) = numList.copyOfRange(n-1, numList.size)
}
