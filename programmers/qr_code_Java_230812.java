package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class qr_code_Java_230812 {
    /*
        두 정수 q, r과 문자열 code가 주어질 때,
        code의 각 인덱스를 q로 나누었을 때
        나머지가 r인 위치의 문자를 앞에서부터
        순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.


     */
    public String solution(int q, int r, String code) {
        String answer = "";

        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                answer += code.charAt(i);
            }
        }

        return answer;
    }
    public String solution_stream(int q, int r, String code) {
        return IntStream.range(0, code.length())    //인덱스 스트림 생성
                .filter(i -> i % q == r)    //조건에 맞는 인덱스 걸러냄
                .mapToObj(code::charAt) //인덱스에 있는 문자를 문자열로 변환함
                .map(String::valueOf)   //문자열을 문자열 스트림으로 변환함
                .collect(Collectors.joining()); //문자열 스트림을 하나의 문자열로 합침
    }

}