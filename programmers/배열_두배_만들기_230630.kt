package programmers

class 배열_두배_만들기_230630 {

    /*
    정수 배열 numbers가 매개변수로 주어집니다.
    numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.

    */
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        for(i in numbers){
            answer += i*2
        }

        return answer
    }

    fun solution_short(numbers: IntArray) = numbers.map { it * 2 }

    /*
    solution 함수는 초기에 빈 배열 answer를 생성합니다.
    그리고 numbers 배열의 각 원소를 반복하면서 해당 원소를 두 배한 값을 answer 배열에 추가합니다.
    반복이 끝나면 answer 배열을 반환합니다.

    solution_short 함수는 더 간결한 구현으로,
    numbers 배열의 각 원소를 두 배한 값을 계산하여
    map 함수를 이용해 새로운 배열로 변환합니다. 이를 바로 반환합니다.
     */
}