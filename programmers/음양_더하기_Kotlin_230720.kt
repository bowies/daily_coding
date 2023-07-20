package programmers

class 음양_더하기_Kotlin_230720 {
    // 배열의 절댓값을 부호에 따라 합산하는 함수 (일반적인 반복문을 사용한 방법)
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        for (i in absolutes.indices) {
            // 만약 부호가 true면 해당 숫자를 더하고, false면 해당 숫자의 음수를 더합니다.
            answer += if (signs[i]) absolutes[i] else -absolutes[i]
        }
        return answer
    }

    // 배열의 절댓값을 부호에 따라 합산하는 함수 (간단한 버전)
    fun solution2(absolutes: IntArray, signs: BooleanArray): Int {
        var answer = 0
        for (i in absolutes.indices) {
            // 만약 부호가 true면 해당 숫자를 더하고, false면 해당 숫자의 음수를 더합니다.
            answer += absolutes[i] * if (signs[i]) 1 else -1
        }
        return answer
    }
    // 스트림을 이용하여 배열의 절댓값을 부호에 따라 합산하는 함수
    fun solution_stream1(absolutes: IntArray, signs: BooleanArray): Int {
        // absolutes와 signs 배열을 zip 함수를 사용하여 순서대로 묶습니다.
        // zip 함수로 묶인 결과는 Pair<Int, Boolean> 타입으로 표현됩니다.
        // map 함수를 이용하여 Pair의 요소를 순회하면서 부호에 따라 값을 변환합니다.
        // 만약 부호가 true라면 해당 숫자는 그대로 유지하고, false라면 해당 숫자의 음수로 변환합니다.
        // 최종적으로 변환된 값들의 합을 sum 함수를 이용하여 구합니다.
        return absolutes.zip(signs.asIterable())
            .map { (number, sign) -> if (sign) number else -number }
            .sum()
    }

    // 스트림을 이용하여 배열의 절댓값을 부호에 따라 합산하는 함수 (간단한 버전)
    fun solution_stream2(absolutes: IntArray, signs: BooleanArray): Int {
        // absolutes 배열의 인덱스를 순회하면서 sumBy 함수를 사용하여 합을 구합니다.
        // sumBy 함수는 각 요소에 대해 수식을 적용한 결과를 모두 합산해 줍니다.
        // 만약 부호가 true라면 해당 숫자는 그대로 유지하고, false라면 해당 숫자의 음수로 변환하여 합산합니다.
        return absolutes.indices.sumBy { i -> absolutes[i] * if (signs[i]) 1 else -1 }
    }

}
