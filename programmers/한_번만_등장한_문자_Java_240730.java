package programmers;

import java.util.*;

class 한_번만_등장한_문자_Java_240730 {

    public String solution(String s) {
        HashMap<Character, Integer> 빈도수 = new HashMap<>();

        for (char chr : s.toCharArray()) {
            빈도수.put(chr, 빈도수.getOrDefault(chr, 0) + 1);
        }

        List<Character> 한번 = new ArrayList<>();

        for (Map.Entry<Character, Integer> map : 빈도수.entrySet()) {
            if (map.getValue() == 1) {
                한번.add(map.getKey());
            }
        }

        Collections.sort(한번);

        StringBuilder answer = new StringBuilder();

        for (char chr : 한번) {
            answer.append(chr);
        }

        return answer.toString();
    }


}