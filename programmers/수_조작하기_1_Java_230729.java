package programmers;

import java.util.HashMap;
import java.util.Map;

class 수_조작하기_1_Java_230729 {
    /*
    정수 n과 문자열 control이 주어집니다.
    control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며,
    control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

    "w" : n이 1 커집니다.
    "s" : n이 1 작아집니다.
    "d" : n이 10 커집니다.
    "a" : n이 10 작아집니다.
    위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
     */
    public int solution(int n, String control) {
        int answer = n;

        for (int i = 0; i < control.length(); i++) {
            switch (control.charAt(i)) {
                case 'w':
                    answer++;
                    break;
                case 's':
                    answer--;
                    break;
                case 'd':
                    answer += 10;
                    break;
                case 'a':
                    answer -= 10;
                    break;
            }
        }

        return answer;
    }

    public int solution2(int n, String control) {
        int answer = n;

        for (int i = 0; i < control.length(); i++) {
            char ch = control.charAt(i);
            if (ch == 'w') {
                answer++;
            } else if (ch == 's') {
                answer--;
            } else if (ch == 'd') {
                answer += 10;
            } else if (ch == 'a') {
                answer -= 10;
            }
        }

        return answer;
    }


    public int solution3(int n, String control) {
        Map<Character, Integer> operationMap = new HashMap<>();
        operationMap.put('w', 1);
        operationMap.put('s', -1);
        operationMap.put('d', 10);
        operationMap.put('a', -10);

        int answer = n;

        for (int i = 0; i < control.length(); i++) {
            char ch = control.charAt(i);
            if (operationMap.containsKey(ch)) {
                answer += operationMap.get(ch);
            }
        }

        return answer;
    }
    public int solution_short(int n, String control) {
        // control.chars()는 control 문자열을 int 스트림으로 변환합니다.
        // 각 문자는 해당 문자에 대한 ASCII 코드값으로 변환됩니다.
        // reduce 메서드는 스트림의 요소를 줄여가면서 연산을 수행합니다.
        // 여기서 acc는 누적된 값이고, c는 현재 처리중인 문자의 ASCII 코드값입니다.
        return control.chars().reduce(n, (answer, i) ->
                // 조건 연산자 (?:)를 사용하여 i의 값에 따라 answer 값을 조작합니다.
                answer + (i == 'w' ? 1 : i == 's' ? -1 : i == 'd' ? 10 : -10)
        );
    }

}