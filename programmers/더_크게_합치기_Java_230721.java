package programmers;

import java.util.stream.Stream;

class 더_크게_합치기_Java_230721 {
    /*
    더 크게 합치기

    문제 설명
    연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.

    12 ⊕ 3 = 123
    3 ⊕ 12 = 312
    양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.

    단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
     */

    public int solution(int a, int b) {
        int ans1 = Integer.parseInt("" + a + b);
        int ans2 = Integer.parseInt("" + b + a);

        return Math.max(ans1, ans2);
    }

    public int solution2(int a, int b) {
        int answer = 0;
        String str1 = Integer.toString(a) + Integer.toString(b);
        String str2 = Integer.toString(b) + Integer.toString(a);

        if(Integer.parseInt(str1) > Integer.parseInt(str2)){
            answer = Integer.parseInt(str1);
        }else{
            answer = Integer.parseInt(str2);
        }

        return answer;
    }


    public int solution_stream(int a, int b) {
        int ans1 = Stream.of(a, b)
                .map(String::valueOf)
                .reduce((s1, s2) -> s1 + s2)
                .map(Integer::parseInt)
                .orElse(0);

        int ans2 = Stream.of(b, a)
                .map(String::valueOf)
                .reduce((s1, s2) -> s1 + s2)
                .map(Integer::parseInt)
                .orElse(0);
        return Math.max(ans1, ans2);
        /*
            위의 코드에서는 Stream.of를 사용하여 두 개의 정수를 스트림으로 만들고,
            map 메소드를 사용하여 정수를 문자열로 변환한 후
            reduce를 통해 두 문자열을 합칩니다.
            그리고 다시 map 메소드를 사용하여 문자열을 정수로 변환하고,
            orElse를 사용하여 값이 없을 경우 0을 반환하도록 처리합니다.
            마지막으로 Math.max를 사용하여 두 값 중 더 큰 값을 반환합니다.
         */
    }

}