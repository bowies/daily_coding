package programmers;

import java.util.Arrays;

class 왼쪽_오른쪽_Java_240402 {
    public String[] solution(String[] str_list) {

        for (int i = 0; i < str_list.length; i++) {

            if ("l".equals(str_list[i])) {
                return Arrays.copyOfRange(str_list, 0, i);
            } else if ("r".equals(str_list[i])) {
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }

        return new String[0];
    }
}
