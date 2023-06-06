package programmers;

import java.util.stream.IntStream;

class 크기가_작은_부분문자열_230606 {
    public int solution(String t, String p) {
        int answer = 0;
        Long pnum = Long.parseLong(p);

        int plength = p.length();

        for(int i = 0; i <= t.length()-plength; i++){
            Long tnum = Long.parseLong(t.substring(i, i+p.length()));
            if(tnum <= pnum){
                answer++;
            }
            //p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.

        }


        return answer;
    }

    public int solution_stream(String t, String p) {
        Long pnum = Long.parseLong(p);
        int plength = p.length();

        return IntStream.rangeClosed(0, t.length() - plength)
                .mapToObj(i -> Long.parseLong(t.substring(i, i + plength)))
                .filter(tnum -> tnum <= pnum)
                .mapToInt(tnum -> 1)
                .sum();
    }

    /*

    Stream을 사용하면 코드를 더 간결하게 표현할 수 있습니다.
    위의 코드에서는 IntStream.rangeClosed를 사용하여 인덱스를 생성하고,
    mapToObj를 사용하여 각 인덱스에 해당하는 부분 문자열을 Long으로 변환합니다.
    그런 다음 filter를 사용하여 조건을 만족하는 부분 문자열만 필터링하고,
    mapToInt를 사용하여 각 조건을 만족하는 부분 문자열을 1로 매핑합니다.
    마지막으로 sum을 호출하여 결과를 합산합니다.

    이렇게 변경된 코드는 Stream을 활용하여 작성되었지만, 성능상의 이점은 크게 없습니다.
    Stream을 사용하면 코드의 가독성과 표현력을 높일 수 있지만, 작업의 복잡성이 증가할 수 있습니다.
    따라서 Stream을 사용할지 여부는 상황과 개발자의 선호에 따라 결정하면 됩니다.
     */

}