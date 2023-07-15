package programmers;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 암호_해독_Java_230715 {
    /*
        군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
        암호화된 문자열 cipher를 주고받습니다.
        그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
        문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.
     */
    public String solution(String cipher, int code) {
        String answer = "";

        for(int i = 0; i < cipher.length(); i++) {
            if((i + 1) % code == 0) {
                answer += cipher.charAt(i);
            }
        }

        return answer;
    }

    public String solution2(String cipher, int code) {
        String answer = "";

        //code 부터 시작해야 함 (code의 배수 번째 글자만 진짜 암호이기 때문)
        //code의 배수 번째 글자만 진짜 암호이기 때문에 code의 배수 번째 글자만 answer에 더해줌
        for (int i = code; i <= cipher.length(); i = i + code) {
            answer += cipher.substring(i - 1, i);
        }

        return answer;
    }


    public String solution_stream(String cipher, int code) {
        return IntStream.range(0, cipher.length())
                // IntStream.range(0, cipher.length())을 사용하여
                // 0부터 cipher 문자열의 길이 직전까지의 정수 범위를 생성합니다.
                .filter(i -> (i + 1) % code == 0)
                // .filter(i -> (i + 1) % code == 0)을 사용하여
                // code의 배수 번째 인덱스만 필터링합니다.
                // (i + 1) % code == 0는
                // 현재 인덱스 i를 code로 나누었을 때 나머지가 0인지 확인합니다.
                .mapToObj(cipher::charAt)
                // .mapToObj(cipher::charAt)를 사용하여
                // 각 인덱스에 해당하는 cipher의 문자를 추출합니다.
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                // .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)를 사용하여
                // 추출된 문자들을 하나의 문자열로 결합합니다.
                // 이때 StringBuilder를 사용하여 문자열을 효율적으로 빌드합니다.
                .toString();
                // .toString()을 호출하여 StringBuilder를 문자열로 변환하여 반환합니다.
    }
    public String solution_stream2(String cipher, int code) {
        return IntStream.iterate(code, i -> i <= cipher.length(), i -> i + code)
                // IntStream.iterate(code, i -> i <= cipher.length(), i -> i + code)를 사용하여
                // code부터 시작하여 code의 배수로 증가하는 정수 스트림을 생성합니다.
                // 이때 i -> i <= cipher.length()를 사용하여 조건을 지정하며,
                // i가 cipher 문자열의 길이보다 작거나 같을 때까지 스트림을 생성합니다.
                .mapToObj(i -> cipher.substring(i - 1, i))
                // .mapToObj(i -> cipher.substring(i - 1, i))를 사용하여
                // 각 정수 i에 해당하는 cipher의 문자를 추출합니다.
                // cipher.substring(i - 1, i)는
                // cipher 문자열에서 i - 1부터 i 직전까지의 부분 문자열을 반환합니다.
                .collect(Collectors.joining());
                // .collect(Collectors.joining())을 사용하여
                // 추출된 문자열들을 하나의 문자열로 결합합니다.
    }

}
