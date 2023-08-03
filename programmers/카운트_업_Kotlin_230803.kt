package programmers

class 카운트_업_Kotlin_230803 {
    /* 배열에 start부터 end까지의 숫자를 차례로 담아 반환하는 함수 */
    fun solution(start: Int, end: Int): IntArray {
        /* 배열의 크기 계산 */
        val size = end - start + 1
        /* 배열 생성하고 숫자를 차례로 담아 반환 */
        return IntArray(size) { i -> start + i }
    }

    /* IntRange를 사용하여 start부터 end까지의 숫자를 리스트로 만들어 배열로 변환하여 반환하는 함수 */
    fun solution_stream(start: Int, end: Int): IntArray {
        /* 리스트로 변환 후 배열로 변환하여 반환 */
        return IntRange(start, end).toList().toIntArray()
    }

    /* IntRange를 사용하여 start부터 end까지의 숫자를 리스트로 만들어 배열로 변환하여 반환하는 함수
       이 함수는 식 형태로 한 줄로 간결하게 작성된 버전입니다. */
    fun solution_best(start: Int, end: Int): IntArray = (start..end).toList().toIntArray()
}
