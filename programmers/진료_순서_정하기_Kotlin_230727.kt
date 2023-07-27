package programmers

class 진료_순서_정하기_Kotlin_230727 {


    fun solution(emergency: IntArray): IntArray {
        val answer = IntArray(emergency.size)

        // 응급도를 내림차순으로 정렬하여 정렬 배열에 저장합니다. (굿!)
        val 정렬 = emergency.sortedDescending()

        // 각 응급도에 대한 순서를 찾아서 answer 배열에 저장합니다.
        for (i in answer.indices) {
            val index = 정렬.indexOf(emergency[i])
            answer[i] = index + 1 // 인덱스는 0부터 시작하므로, 1을 더해 1-based indexing으로 만듭니다.
        }

        return answer
    }



    fun solution2(emergency: IntArray): IntArray {
        // 응급도별 순서를 저장하는 Map을 생성합니다.
        val map = mutableMapOf<Int, Int>()

        // emergency 배열을 복사한 뒤 정렬하여 응급도별로 오름차순으로 정렬된 배열을 생성합니다.
        val 정렬 = emergency.sorted()

        // 정렬된 응급도 배열을 순회하며 응급도별 순서를 Map에 저장합니다.
        // 순서는 배열 길이에서 인덱스를 뺀 값입니다.
        for ((i, value) in 정렬.withIndex()) {
            map[value] = emergency.size - i
        }

        // 원래 emergency 배열에 저장된 응급도를 순회하며 Map에서 해당 응급도의 순서를 찾아서 다시 배열에 저장합니다.
        for (i in emergency.indices) {
            emergency[i] = map[emergency[i]] ?: 0
        }

        return emergency
    }

    fun solution_best(e: IntArray) = e.map { e.sortedDescending().indexOf(it) + 1 }.toIntArray()
    /*


    1. `e.map { ... }` :
    `e` 배열의 모든 요소에 대해 순회하며 새로운 List를 생성합니다.

    2. `{ e.sortedDescending().indexOf(it) + 1 }` :
    순회 중인 배열 요소 `it`에 대해 작업을 수행하는 람다 표현식입니다.

    3. `e.sortedDescending()` :
    `e` 배열을 내림차순으로 정렬합니다.

    4. `.indexOf(it)` :
    정렬된 배열에서 현재 요소 `it`의 인덱스를 찾습니다.

    5. `+ 1` :
    인덱스는 0부터 시작하므로, 1을 더해 1-based indexing으로 만듭니다.

    6. `.toIntArray()` :
    List를 다시 `IntArray`로 변환하여 반환합니다.

    결과적으로, 해당 코드는 입력으로 주어진 응급도 배열 `e`를 내림차순으로 정렬하고,
    각 응급도에 대한 순서를 찾아서 새로운 배열로 반환합니다.
    이러한 코드 스타일을 활용하면 코드를 더욱 간결하게 작성할 수 있습니다.
     */
}