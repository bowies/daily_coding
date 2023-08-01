package programmers

class k의_개수_Kotlin_230801 {
    // 첫 번째 솔루션: 문자열로 변환하여 문자를 접근하는 방법
    fun solution(i: Int, j: Int, k: Int): Int {
        var answer = 0

        for (n in i..j) {
            // 숫자를 문자열로 변환
            val temp = n.toString()

            // 문자열의 각 자릿수를 순회하며 k와 일치하는지 확인
            for (m in temp.indices) {
                if (temp[m] == k.toString()[0]) {
                    answer++
                }
            }
        }

        return answer
    }

    // 두 번째 솔루션: 수학적 연산으로 각 자릿수를 추출하여 k와 일치하는지 확인
    fun solution2(i: Int, j: Int, k: Int): Int {
        var answer = 0

        var n = i
        while (n <= j) {
            var temp = n
            while (temp > 0) {
                // 수학적 연산을 통해 숫자의 각 자릿수를 추출
                val digit = temp % 10
                if (digit == k) {
                    answer++
                }
                temp /= 10
            }
            n++
        }

        return answer
    }

    // 최적화된 솔루션: 문자열을 사용하지 않고 각 숫자를 문자열로 변환하여 처리
    fun solution_best(i: Int, j: Int, k: Int): Int {
        var temp = ""

        // i부터 j까지의 범위의 모든 숫자를 문자열로 이어붙임
        for (n in i..j) {
            temp += n.toString()
        }

        // 문자열에서 k와 일치하는 문자를 제거하고 남은 길이를 구하여 등장 횟수를 계산
        return temp.length - temp.replace(k.toString(), "").length
    }


    fun solution_best2(i: Int, j: Int, k: Int): Int = (i..j).joinToString("").count { it.digitToInt() == k }


    fun solution_best2_해석(i: Int, j: Int, k: Int): Int =
        (i..j).joinToString("").count { it.digitToInt() == k }

    /*

    설명:
    1. `i..j`: `i`부터 `j`까지의 범위를 나타내는 Kotlin의 범위 표현식입니다. 이 범위에 속하는 숫자들로 이루어진 시퀀스를 생성합니다.
       예를 들어, `i`가 1이고 `j`가 5라면 시퀀스는 1, 2, 3, 4, 5로 이루어집니다.

    2. `joinToString("")`: 시퀀스 내의 모든 숫자들을 빈 문자열("")로 구분하여 하나의 문자열로 이어붙입니다.
       예를 들어, 시퀀스가 1, 2, 3, 4, 5로 이루어져 있다면, 이 함수를 사용하면 "12345"라는 문자열을 얻습니다.

    3. `count { it.digitToInt() == k }`: 문자열의 각 문자를 순회하면서 `k`와 같은 숫자의 개수를 세는 작업을 수행합니다.
       - `count`: Kotlin의 문자열 함수로, 주어진 조건식을 만족하는 문자의 개수를 반환합니다.
       - `{ it.digitToInt() == k }`: 람다식을 사용하여 각 문자를 정수로 변환한 뒤, `k`와 같은지 비교합니다.
         - `it`: 람다식 내에서 현재 순회 중인 문자를 나타내는 변수입니다.
         - `digitToInt()`: 문자를 정수로 변환하는 Kotlin의 문자열 확장 함수입니다.

     */

}