package programmers;

import java.util.stream.IntStream;

class 숫자_찾기_Java_230716 {

    /*
        정수 num과 k가 매개변수로 주어질 때,
        num을 이루는 숫자 중에 k가
        있으면 num의 그 숫자가 있는 자리 수를 return하고
        없으면 -1을 return 하도록 solution 함수를 완성해보세요.
     */
    public int solution(int num, int k) {
        int answer = -1;


        for(int i = 0; i < String.valueOf(num).length(); i++) {
            if(String.valueOf(num).charAt(i) == String.valueOf(k).charAt(0)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
    public int solution2(int num, int k) {
        String numString = String.valueOf(num);

        char chr = String.valueOf(k).charAt(0); //String.valueOf(k).charAt(0)를 변수 char에 저장하여 코드 가독성을 개선합니다.

        for(int i = 0; i < numString.length(); i++) {
            if(numString.charAt(i) == chr) {
                return i + 1;
            }
        }

        return -1;
    }


    public int solution_stream(int num, int k) {
        String numString = String.valueOf(num); // 주어진 num을 문자열로 변환하여 numString에 저장합니다.

        char chr = String.valueOf(k).charAt(0); // 주어진 k를 문자열로 변환한 후 첫 번째 문자를 chr에 저장합니다.

        return IntStream.range(0, numString.length()) // 0부터 numString의 길이까지의 인덱스 범위를 생성합니다.
                .filter(i -> numString.charAt(i) == chr) // numString에서 chr과 일치하는 문자를 찾습니다.
                .findFirst() // 일치하는 첫 번째 인덱스를 찾습니다.
                .orElse(-1) + 1; // 일치하는 값이 없으면 -1을 반환하고, 일치하는 값이 있으면 1을 더한 후 반환합니다.
    }

    public int solution_short(int num, int k) {
        /*
            주어진 `num`에 대해 "-"을 추가하여 문자열로 변환하고,
            그 문자열에서 `k`를 찾는 방법을 사용합니다.

            1. `num`을 문자열로 변환하기 위해 `num`을 "-"와 연결하여 문자열로 만듭니다.
            이렇게 함으로써 음수인 경우에도 처리할 수 있습니다.
            2. `String.valueOf(k)`를 사용하여 `k`를 문자열로 변환합니다.
            3. `indexOf` 메서드를 사용하여 문자열에서 `k`가 처음 등장하는 인덱스를 찾습니다.
            `indexOf` 메서드는 주어진 문자열에서
            특정 문자열 또는 문자의 첫 번째 등장 위치를 찾아 해당 인덱스를 반환합니다.
            4. `return` 문을 사용하여 결과를 반환합니다.

            위의 코드는 문자열 연산을 사용하여 구현되어 있으며, 한 줄로 간결하게 작성되어 있습니다.
            하지만 성능 면에서는 다소 비효율적일 수 있습니다.
            `indexOf` 메서드는 문자열을 순차적으로 검색하기 때문에 시간 복잡도가 O(n)입니다.
            따라서 `solution` 함수의 시간 복잡도는 문자열의 길이에 따라 선형적으로 증가할 수 있습니다.

            최적화된 버전의 코드는 문자열을 사용하는 대신 반복문으로 숫자를 검색하는 방식을 사용하므로 성능 면에서 더 효율적일 수 있습니다.
         */

        return ("-" + num).indexOf(String.valueOf(k));
    }
}