package programmers

class 뒤에서_5등_위로_Kotlin_230712 {
    /*
        정수로 이루어진 리스트 num_list가 주어집니다.
        num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
     */
    fun solution(num_list: IntArray): IntArray {

        val sortArray = num_list.sorted().toIntArray()
        // 주어진 num_list를 정렬하여 sortArray에 저장합니다.


        val answer = IntArray(num_list.size - 5)
        // 정답을 저장할 배열을 생성합니다.
        // 정답 배열의 크기는 num_list의 크기에서 5를 뺀 값입니다.

        for (i in answer.indices) {
            // 정답 배열을 채웁니다.
            // sortArray에서 index i + 5에 해당하는 값을 정답 배열의 i번째에 저장합니다.

            answer[i] = sortArray[i + 5]
        }
        /*
            `indices`는 Kotlin의 표준 라이브러리 함수로,
            주어진 컬렉션의 유효한 인덱스 범위를 나타내는 IntRange 객체를 반환합니다.

            예를 들어, 리스트의 인덱스 범위는 0부터 리스트의 크기에서 1을 뺀 값까지입니다.
            따라서 `list.indices`는 `0 until list.size`와 같은 결과를 갖는 IntRange 객체를 반환합니다.

            이를 활용하여 반복문에서 인덱스를 사용할 때 `indices`를 이용하면,
            리스트의 크기에 상관없이 안전하게 인덱스를 접근할 수 있습니다.

            예를 들어, `for (i in list.indices)`는 리스트의 모든 유효한 인덱스에 대해 반복할 수 있습니다.

            따라서 `answer.indices`는 `answer` 배열의 유효한 인덱스 범위를 나타내는 IntRange 객체를 반환합니다.
            이를 활용하여 `answer` 배열을 반복문에서 채울 때 `i in answer.indices`와 같은 형태로 사용할 수 있습니다.
         */

        return answer
    }


    fun solution_stream(num_list: IntArray): IntArray {
        return num_list.sorted().drop(5).toIntArray()
        // num_list를 정렬한 후 처음부터 5개의 요소를 건너뛴 뒤, 남은 요소들을 정수 배열로 변환하여 반환합니다.
    }

}