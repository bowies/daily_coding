package programmers;

import java.util.Arrays;
import java.util.Comparator;

class PCCE_기출문제_10번_데이터_분석_Java_240123 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        int[][] answer = Arrays.stream(data)
                .filter(item -> {
                    if ("date".equals(ext)) {
                        return item[1] < val_ext;
                    } else if ("maximum".equals(ext)) {
                        return item[2] < val_ext;
                    } else if ("remain".equals(ext)) {
                        return item[3] < val_ext;
                    } else {
                        return item[0] < val_ext;
                    }
                })
                .toArray(int[][]::new);

        Arrays.sort(answer, Comparator.comparingInt(item -> {
            if ("code".equals(sort_by)) {
                return item[0];
            } else if ("date".equals(sort_by)) {
                return item[1];
            } else if ("maximum".equals(sort_by)) {
                return item[2];
            } else {
                return item[3];
            }
        }));

        return answer;
    }
}
