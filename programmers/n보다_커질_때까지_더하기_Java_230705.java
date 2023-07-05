package programmers;

import java.util.Arrays;

class n보다_커질_때까지_더하기_Java_230705 {
    public int solution(int[] numbers, int n) {
        int answer = 0;

        for(int i = 0; i < numbers.length; i++){
            answer += numbers[i];
            if(answer > n){
                break;
            }
        }
        return answer;
    }

    public int solution_stream(int[] numbers, int n) {
        return Arrays.stream(numbers).reduce(0, (acc, i) -> n >= acc ? acc + i : acc);
    }
    /*

    `solution` 메서드는 반복문을 사용하여
    `numbers` 배열의 요소를 더하고,
    합이 `n`보다 커지면 더 이상 반복하지 않고 결과를 반환합니다.

    `solution_stream` 메서드는 스트림을 사용하여 동일한 작업을 수행합니다.
    `Arrays.stream(numbers)`를 사용하여
    `numbers` 배열을 스트림으로 변환하고,
    `reduce` 메서드를 사용하여 배열의 요소들을 누적 합산합니다.
    이 때, `acc`는 누적된 합계이고 `i`는 현재 요소입니다.
    `n`과 `acc`를 비교하여 누적 합계가 `n`보다 작거나 같으면 현재 요소를 더하고,
    그렇지 않으면 누적 합계를 그대로 유지합니다. 최종적으로 합산된 값을 반환합니다.

     */
}