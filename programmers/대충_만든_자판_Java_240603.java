package programmers;

import java.util.*;

class 대충_만든_자판_Java_240603{
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> 최소누름세기 = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            String key = keymap[i];
            for (int j = 0; j < key.length(); j++) {
                char 문자 = key.charAt(j);
                int cnt = j + 1;

                if (최소누름세기.containsKey(문자)) {
                    // 이미 존재 할 때는 최소 값만 유지한다.
                    최소누름세기.put(문자, Math.min(최소누름세기.get(문자), cnt));
                } else {
                    최소누름세기.put(문자, cnt);
                }
            }
        }

        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String 타겟 = targets[i];
            int total = 0;
            boolean available = true;

            for (int j = 0; j < 타겟.length(); j++) {
                char 문자 = 타겟.charAt(j);

                if (최소누름세기.containsKey(문자)) {
                    total += 최소누름세기.get(문자);
                } else {
                    available = false;
                    break;
                }
            }

            if (available) {
                answer[i] = total;
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }
}
