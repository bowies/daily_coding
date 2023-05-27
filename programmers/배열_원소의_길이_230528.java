package programmers;

import java.util.Arrays;

class 배열_원소의_길이_230528 {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist)
                .mapToInt(String::length)
                .toArray();
    }

    public int[] solution_arr(String[] strlist) {
        int[] answer = new int[strlist.length];
        for(int i = 0; i < strlist.length; i++){
            answer[i] = strlist[i].length();
        }
        return answer;
    }

}