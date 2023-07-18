package programmers

class 카운트_다운_Kotlin_230718 {

    fun solution(start: Int, end: Int): IntArray {

        // 결과를 저장할 배열 생성
        val answer = IntArray(start - end + 1)

        // 배열에 값을 할당하는 반복문
        for (i in answer.indices) {
            answer[i] = start - i
        }

        // 결과 배열 반환
        return answer

    }


    fun solution_stream(start: Int, end: Int): IntArray {
        // IntRange를 사용하여 start에서 end까지의 범위 생성
        // map을 사용하여 각 요소를 변환하여 배열로 반환
        return (end..start).map { start - it + end }.toIntArray()
    }

    fun solution_short(start: Int, end: Int) = (end..start).toList().sortedDescending()
    /*
        1. (end..start)를 사용하여 end부터 start까지의 범위를 생성합니다. 이는 Kotlin의 IntRange를 사용하여 범위를 표현하는 것입니다.
        2. toList()를 호출하여 범위를 리스트로 변환합니다. 이는 IntRange의 요소들을 리스트에 저장하는 역할을 합니다.
        3. sortedDescending()를 호출하여 리스트를 내림차순으로 정렬합니다. 이는 리스트의 요소들을 큰 수부터 작은 수 순서로 정렬하는 역할을 합니다.
        4. 정렬된 리스트가 함수의 반환값으로 사용됩니다.
     */
}