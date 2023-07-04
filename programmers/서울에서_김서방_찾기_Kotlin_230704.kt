package programmers

class 서울에서_김서방_찾기_Kotlin_230704 {
    fun solution(seoul: Array<String>): String {
        val 김서방 = "Kim"
        var answer: String? = null
        for (i in seoul.indices) {
            if (seoul[i].equals(김서방, ignoreCase = true)) {
                answer = "김서방은 $i"+"에 있다"
            }
        }
        return answer ?: ""
    }
    /*
        `solution` 함수는 주어진 `seoul` 배열에서 "Kim"을 찾아 해당 인덱스를 포함한 문자열을 반환하는 함수입니다.
        먼저, "Kim"을 `김서방`이라는 `val` 변수에 저장합니다.
        그리고 `answer` 변수를 `null`로 초기화합니다.
        `for` 루프를 통해 `seoul` 배열의 인덱스를 순회하면서,
        각 요소가 `김서방`과 대소문자 무시하여 일치하는지 확인합니다.
        일치하는 경우 `answer`에 "김서방은 $i에 있다" 형식의 문자열을 할당합니다.
        최종적으로 `answer`가 `null`인 경우 빈 문자열을 반환합니다.
     */

    fun solution_short(seoul: Array<String>): String = "김서방은 ${seoul.indexOf("Kim")}에 있다"
    /*
        `solution_short` 함수는 더 간결한 형태로 "Kim"의 인덱스를 찾아 해당 문자열을 반환하는 함수입니다.
        `seoul.indexOf("Kim")`을 사용하여 "Kim"의 인덱스를 찾고,
        문자열 템플릿(`$`)을 사용하여 "김서방은 해당 인덱스에 있다" 형식의 문자열을 반환합니다.
     */

}