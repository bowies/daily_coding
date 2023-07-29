package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class 수_조작하기_2_Java_230730 {
    /*
    정수 배열 numLog가 주어집니다.
    처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.

    "w" : 수에 1을 더한다.
    "s" : 수에 1을 뺀다.
    "d" : 수에 10을 더한다.
    "a" : 수에 10을 뺀다.
    그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다.
    즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.

    주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.

    입출력 예
    numLog	result
    [0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1]	"wsdawsdassw"
     */
    public String solution(int[] numLog) {
        String answer = "";

        for (int i = 1; i < numLog.length; i++) {
            int 입력된문자열 = numLog[i] - numLog[i - 1];
            if (입력된문자열 == 1) {
                answer += "w";
            } else if (입력된문자열 == -1) {
                answer += "s";
            } else if (입력된문자열 == 10) {
                answer += "d";
            } else if (입력된문자열 == -10) {
                answer += "a";
            }
        }


        return answer;
    }


    public String solution2(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < numLog.length; i++) {
            int 입력된문자열 = numLog[i] - numLog[i - 1];
            if (입력된문자열 == 1) {
                sb.append("w");
            } else if (입력된문자열 == -1) {
                sb.append("s");
            } else if (입력된문자열 == 10) {
                sb.append("d");
            } else if (입력된문자열 == -10) {
                sb.append("a");
            }
        }

        return sb.toString();
    }

    public String solution_stream(int[] numLog) {
        return IntStream.range(1, numLog.length)
                .mapToObj(i -> {
                    int 입력된문자열 = numLog[i] - numLog[i - 1];
                    if (입력된문자열 == 1) {
                        return "w";
                    } else if (입력된문자열 == -1) {
                        return "s";
                    } else if (입력된문자열 == 10) {
                        return "d";
                    } else if (입력된문자열 == -10) {
                        return "a";
                    } else {
                        return "";
                    }
                })
                .collect(Collectors.joining());
    }

    public String solution_stream2(int[] numLog) {
        return IntStream.range(1, numLog.length)
                .mapToObj(i -> {
                    int 입력된문자열 = numLog[i] - numLog[i - 1];
                    if (입력된문자열 == 1) {
                        return "w";
                    } else if (입력된문자열 == -1) {
                        return "s";
                    } else if (입력된문자열 == 10) {
                        return "d";
                    } else if (입력된문자열 == -10) {
                        return "a";
                    } else {
                        return "";
                    }
                })
                .collect(Collectors.joining());
    }

}