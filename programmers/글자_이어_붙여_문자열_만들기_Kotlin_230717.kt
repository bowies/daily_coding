package programmers
class 글자_이어_붙여_문자열_만들기_Kotlin_230717 {
    /*
        문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다.
        my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을
        return 하는 solution 함수를 작성해 주세요.
     */
    fun solution(my_string: String, index_list: IntArray): String {
        val my_string_array = my_string.toCharArray()
        var answer = ""

        for (i in index_list) {
            answer += my_string_array[i]
        }

        return answer
        /*
            my_string을 문자 배열로 변환하여 my_string_array에 저장합니다.
            초기화된 빈 문자열 answer를 선언합니다.
            index_list의 각 원소 i에 대해서 my_string_array[i]의 값을 answer에 이어붙입니다.
            최종적으로 이어붙인 answer를 반환합니다.
         */
    }
    fun solution2(my_string: String, index_list: IntArray): String {
        val sb = StringBuilder()

        for (index in index_list) {
            sb.append(my_string[index])
        }

        return sb.toString()
        /*
            StringBuilder를 사용하여 효율적으로 문자열을 이어붙입니다.
            index_list의 각 원소 index에 대해서 my_string[index]의 값을 sb에 추가합니다.
            sb.toString()을 호출하여 StringBuilder 객체에 저장된 문자열을 반환합니다.
         */
    }

    fun solution_stream(my_string: String, index_list: IntArray): String {
        return index_list
            .map {i -> my_string[i].toString() } //.map {my_string[it].toString() }
            .joinToString("")
        /*
            index_list를 스트림으로 변환합니다.
            map 함수를 사용하여 각 원소 i를 my_string[i].toString()로 변환합니다.
            joinToString 함수를 사용하여 변환된 문자열을 이어붙여 최종 결과를 반환합니다.
         */
    }
}
