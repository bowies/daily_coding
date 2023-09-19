package programmers;

import java.util.Arrays;

class 외계어_사전_Java_230918 {
    /*
    PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다.
    알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다.
    spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가
    dic에 존재한다면 1,
    존재하지 않는다면 2를
    return하도록 solution 함수를 완성해주세요.
     */
    public int solution(String[] spell, String[] dic) {
        int answer = 2;

        // spell 배열의 알파벳을 정렬한다.
        Arrays.sort(spell);

        // dic 배열에 있는 단어들을 하나씩 검사한다.
        for (String str : dic) {
            // word 배열의 알파벳도 정렬하여 비교하기 쉽게 만든다.
            char[] 단어배열 = str.toCharArray();
            Arrays.sort(단어배열);
            String 정렬된단어 = new String(단어배열);

            // spell과 [정렬된단어]가 동일하면 spell 배열의 알파벳을 한 번씩만 사용한 것이므로 1을 반환한다.
            if (Arrays.equals(spell, 정렬된단어.split(""))) {
                return 1;
            }
        }

        return answer;
    }


    public int solution2(String[] spell, String[] dic) {
        int answer = 2;

        // spell 배열의 알파벳을 정렬한다.
        Arrays.sort(spell);

        // dic 배열에 있는 단어들을 스트림으로 처리하고, 조건에 맞는 단어가 있는지 확인한다.
        boolean flag = Arrays.stream(dic)
                .map(str -> str.chars().sorted() // 알파벳을 정렬한 문자열로 변환
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString())
                .anyMatch(sortedWord -> Arrays.equals(spell, sortedWord.split("")));

        // found가 true이면 spell 배열의 알파벳을 한 번씩만 사용한 단어가 있으므로 1을 반환한다.
        if (flag) {
            return 1;
        }

        return answer;
    }

}