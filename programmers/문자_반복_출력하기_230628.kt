package programmers

class 문자_반복_출력하기_230628 {

    // 문자열 my_string과 정수 n이 매개변수로 주어질 때,
    // my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.
    fun solution(my_string: String, n: Int): String {
        var answer: String = ""

        for(i in my_string){
            for(j in 1..n){
                answer += i
            }
        }

        return answer
    }

    fun solution_short(myString: String, n: Int) =
        myString.map { it.toString().repeat(n) }.joinToString("")

    /*
        첫 번째 함수인 solution 함수는 두 개의 매개변수 my_string과 n을 받고, 결과로 반복된 문자열을 반환합니다.
        answer라는 빈 문자열을 초기화하고,
        my_string의 각 문자를 하나씩 반복하면서
        내부의 두 번째 반복문에서 해당 문자를 n번 반복하여 answer에 추가합니다.
        이렇게 모든 문자를 반복하여 answer에 저장한 후, 최종적으로 answer를 반환합니다.

        두 번째 함수인 solution_short 함수는 더 간단한 버전의 구현입니다.
        solution 함수와 동일한 기능을 수행하지만, 한 줄로 표현되어 있습니다.
        myString의 각 문자를 n번 반복한 후,
        문자열로 변환하여 리스트에 저장한 뒤,
        joinToString 함수를 사용하여 리스트의 요소들을 연결한 최종 결과를 반환합니다.
     */
}