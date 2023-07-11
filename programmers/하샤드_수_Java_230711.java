package programmers;

class 하샤드_수_Java_230711 {
    /*
        양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
        예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
        자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
     */
    public boolean solution(int x) {

        int 자릿수의합 = 0;
        int 하샤드수 = x;

        while (하샤드수 > 0) {
            자릿수의합 += 하샤드수 % 10; // 마지막 자릿수를 구해서 sum에 더함
            하샤드수 /= 10; // 마지막 자릿수를 제거

        }

        boolean answer = x % 자릿수의합 == 0;

        return answer;
    }


    public boolean solution_short(int x) {
        int answer = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x % answer == 0;
    }
    /*
        1. `String.valueOf(x)`를 사용하여 정수 `x`를 문자열로 변환합니다.

        2. `chars()` 메소드를 호출하여 문자열을 `IntStream`으로 변환합니다.
        이 때, 각 문자는 ASCII 코드로 표현됩니다.

        3. `map(ch -> ch - '0')`를 사용하여 각 문자를 정수로 변환합니다.
        이 때, `'0'`을 빼주어 ASCII 코드에서 해당 숫자의 실제 값을 얻습니다.

        4. `sum()` 메소드를 호출하여 정수 스트림의 합을 계산합니다. 즉, 자릿수의 합을 구합니다.
        return x % answer == 0;

        위 코드는 주어진 수 `x`를 자릿수의 합인 `answer`으로 나눈 나머지를 확인하여 결과를 반환합니다.
        - `x`를 `answer`으로 나누었을 때 나머지가 0이면 `true`를 반환합니다. 즉, 자릿수의 합으로 나누어지는 경우입니다.
        - 그렇지 않으면 `false`를 반환합니다. 즉, 자릿수의 합으로 나누어지지 않는 경우입니다.
     */


}