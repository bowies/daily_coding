package programmers;

import java.util.*;

class 그림_확대_Java_240610 {

    public String[] solution(String[] picture, int k) {
        int 행 = picture.length;
        int 열 = picture[0].length();

        int 그림행 = 행 * k;
        int 그림열 = 열 * k;
        String[] 그림 = new String[그림행];

        for (int i = 0; i < 그림행; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 그림열; j++) {
                sb.append(picture[i / k].charAt(j / k));
            }
            그림[i] = sb.toString();
        }

        return 그림;
    }
}
