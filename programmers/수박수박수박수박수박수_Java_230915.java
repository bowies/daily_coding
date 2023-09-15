package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class 수박수박수박수박수박수_Java_230915 {
    /*
        길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수,
        solution을 완성하세요.
        예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.


     */
    public String solution(int n) {
        String answer = "";
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                answer += "수";
            } else {
                answer += "박";
            }
        }
        return answer;
    }


    public String solution2(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append("수");
            } else {
                sb.append("박");
            }
        }

        return sb.toString();
    }
    public String solution_stream(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> i % 2 == 0 ? "수" : "박")
                .collect(Collectors.joining());
    }

}