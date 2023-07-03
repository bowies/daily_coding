package programmers

class 기사단원의_무기_Kotlin_230703 {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer = 0

        // 주어진 숫자 number까지 반복문을 실행하면서 각 숫자의 약수 개수를 구합니다.
        // 이를 위해 Math.sqrt() 함수를 사용하여 i의 제곱근까지만 반복합니다.
        // 약수를 찾을 때는 i를 j로 나눈 나머지가 0인 경우 약수로 간주하고, 약수 변수를 증가시킵니다.
        // 중복 약수를 피하기 위해 i / j와 j가 다른 경우에는 약수를 하나 더 추가합니다.

        for (i in 1..number) {
            var 약수 = 0

            for (j in 1..(Math.sqrt(i.toDouble()).toInt())) {
                if (i % j == 0) {
                    약수++
                    if (i / j != j) {
                        약수++
                    }
                }
            }

            if (약수 <= limit) {
                answer += 약수
            } else {
                answer += power
            }
        }

        return answer
    }




    fun solution_knowledge(number: Int, limit: Int, power: Int): Int {
        // IntArray를 사용하여 크기가 number인 배열을 생성합니다.
        // 배열의 각 요소는 약수계산 함수를 호출하여 해당 숫자의 약수 개수를 계산합니다.
        // IntArray의 초기값을 설정하기 위해 약수계산(it + 1)로 호출합니다.
        // 여기서 it은 배열의 인덱스를 나타내며, + 1을 통해 1부터 시작하는 숫자를 나타냅니다.

        // 배열의 요소를 모두 계산한 후 fold 함수를 사용하여 배열을 순회하면서 무기의 철의 무게를 계산합니다.
        // fold 함수의 초기값은 0으로 설정되며, 각 요소 약수를 이용하여 무기의 철의 무게를 계산합니다.
        // 약수는 약수 개수를 나타내는 변수입니다.
        // 약수 개수 약수가 공격력 제한 수치 limit보다 큰 경우 array + power를 반환하고,
        // 그렇지 않은 경우 array + 약수를 반환합니다.

        return IntArray(number) { 약수계산(it + 1) }
            .fold(0) {
                    array, 약수 ->
                        if (약수 > limit)
                            array + power
                        else
                            array + 약수
        }
    }

    private fun 약수계산(n : Int): Int {
        // 약수계산 함수는 주어진 숫자 n의 약수 개수를 계산하는 기능을 수행합니다.
        // count 변수를 0으로 초기화하고, i 변수를 1로 설정합니다.
        // while 루프를 통해 i * i가 n보다 작은 동안 약수를 찾습니다.
        // n을 i로 나눈 나머지가 0인 경우 약수로 간주하고, count를 2 증가시킵니다.
        // i를 1 증가시킨 후 다음 숫자에 대해 약수를 찾습니다.
        // i * i가 n과 같은 경우에는 count를 1 증가시킵니다.
        // 마지막으로 count를 반환합니다.

        var count = 0
        var i = 1

        while (i * i < n) {
            if (n % i++ == 0)
                count += 2
        }

        if (i * i == n)
            count++

        return count
    }
}