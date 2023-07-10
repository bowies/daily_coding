package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class 이어_붙인_수_Java_230710 {
    /*
        정수가 담긴 리스트 num_list가 주어집니다.
        num_list의 홀수만 순서대로 이어 붙인 수와
        짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
     */
    public int solution(int[] num_list) {
        int answer = 0;

        String 홀수 = "";
        String 짝수 = "";

        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 0) {
                짝수 += num_list[i];
            } else {
                홀수 += num_list[i];
            }
        }

        answer = Integer.parseInt(홀수) + Integer.parseInt(짝수);


        return answer;
    }




    public int solution_stream(int[] num_list) {
        String 홀수 = IntStream.of(num_list)
                .filter(n -> n % 2 != 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        String 짝수 = IntStream.of(num_list)
                .filter(n -> n % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        int answer = Integer.parseInt(홀수) + Integer.parseInt(짝수);

        return answer;
    }



    public int solution_stream_help(int[] num_list) {
        return Integer.parseInt(
                    Arrays.stream(num_list)
                    .filter(value -> value % 2 != 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining()))
                +
                Integer.parseInt(
                    Arrays.stream(num_list)
                    .filter(value -> value % 2 == 0)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining()));
    }

    // 유명한 분이 작성한 코드 열심히 떼어서 봤는데 위에 내가 열시미 바꾼 코드랑 똑같고, 한줄로 합친거였음... -.-)... 그래도 멋지네요...
    // return Integer.parseInt(Arrays.stream(numList).filter(value -> value % 2 != 0).mapToObj(String::valueOf).collect(Collectors.joining())) + Integer.parseInt(Arrays.stream(numList).filter(value -> value % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining()));
    // 원래 이렇게 생겼음... 어떤 것이든 한 줄로 해결하는 저 분...

    /*

    1. `Arrays.stream(numList)`:
        `numList` 배열을 `stream`으로 변환합니다.
        `stream`은 배열이나 컬렉션과 같은 요소들의 시퀀스를 처리하는 기능을 제공합니다.

    2. `.filter(value -> value % 2 != 0)`:
        `stream`의 요소들 중에서 홀수인 값들만 걸러냅니다.
        `%` 연산자를 사용하여 값을 2로 나누었을 때 나머지가 0이 아닌 값들을 선택합니다.

    3. `.mapToObj(String::valueOf)`:
        `stream`의 정수 값을 문자열 값으로 변환합니다.
        `valueOf` 메서드는 정적 메서드이며, `int` 값을 문자열로 변환합니다.

    4. `.collect(Collectors.joining())`:
        변환된 문자열 값들을 하나의 문자열로 결합합니다.
        `joining()` 메서드는 `Collectors` 클래스에 정의된 정적 메서드로,
        `stream`의 요소들을 하나로 연결할 때 사용합니다.

    5. `Integer.parseInt(...)`:
        문자열 값을 정수 값으로 변환합니다.
        `parseInt` 메서드는 `Integer` 클래스에 정의된 정적 메서드로, 문자열을 정수로 변환합니다.

    6. `+`: 두 개의 정수 값을 더합니다.

    7. 위의 6~10 단계를 한 번 더 반복하여, `numList` 배열의 짝수 값들을 처리하고 더합니다.

    8. 최종적으로 두 개의 정수 값의 합을 반환합니다.

 */
}