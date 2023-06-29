package programmers

class 모음_제거_230629 {
    // 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다.
    // 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
    fun solution(my_string: String): String {
        var answer: String = ""

        for(i in my_string){
            if(i != 'a' && i != 'e' && i != 'i' && i != 'o' && i != 'u'){
                answer += i
            }
        }

        return answer
    }

    // 위의 solution 함수를 최적화한 버전
    fun solution2(my_string: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        val answer = StringBuilder()

        for (char in my_string) {
            if (char !in vowels) {
                answer.append(char)
            }
        }

        return answer.toString()
    }

    // 정규표현식을 이용한 간단한 해결 방법
    fun solution3(myString: String) = myString.replace("a|e|i|o|u".toRegex(), "")
}
