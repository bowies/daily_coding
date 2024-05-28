package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

class _7의_개수_Java_240528 {
    public int solution(int[] array) {
        int answer = 0;

        for (int i : array) {
            String str = Integer.toString(i);
            for (char c : str.toCharArray()) {
                if (c == '7') {
                    answer++;
                }
            }
        }
        
        return answer;
    }


    public int solution_stream(int[] array) {
        return (int) Arrays.stream(
                        Arrays.stream(array) // 스트림 변환
                                .mapToObj(String::valueOf) // 요소별로 문자열로 치환
                                .collect(Collectors.joining()) // 문자를 하나로 합침
                                .split("") // 개별 문자로 나눔
                )
                .filter(s -> s.equals("7")) // 각 문자가 7인지 필터링
                .count(); //필터링한 개수 카운트
    }
}