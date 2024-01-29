package programmers;

import java.util.HashMap;
import java.util.Map;

class 가장_많이_받은_선물_Java_240129 {
    public int solution(String[] 친구들, String[] 선물) {
        Map<String, Integer> map = new HashMap<>();
        int[][] 선물표 = new int[친구들.length][친구들.length];
        int[] 선물수 = new int[친구들.length];

        for (int i = 0; i < 친구들.length; i++) {
            map.put(친구들[i], i);
        }

        for (String gift : 선물) {
            String[] splitGift = gift.split(" ");
            int 주는인덱스 = map.get(splitGift[0]);
            int 받는인덱스 = map.get(splitGift[1]);
            선물표[주는인덱스][받는인덱스] += 1;
        }

        int[] 총주는수 = new int[친구들.length];
        int[] 총받는수 = new int[친구들.length];

        for (int i = 0; i < 친구들.length; i++) {
            for (int j = 0; j < 친구들.length; j++) {
                총주는수[i] += 선물표[i][j];
                총받는수[j] += 선물표[i][j];
            }
        }

        int[] 선물지수 = new int[친구들.length];
        for (int i = 0; i < 친구들.length; i++) {
            선물지수[i] = 총주는수[i] - 총받는수[i];
        }

        for (int i = 0; i < 친구들.length; i++) {
            for (int j = i + 1; j < 친구들.length; j++) {
                if (선물표[i][j] > 선물표[j][i]) {
                    선물수[i]++;
                } else if (선물표[j][i] > 선물표[i][j]) {
                    선물수[j]++;
                } else {
                    if (선물지수[i] > 선물지수[j]) {
                        선물수[i]++;
                    }
                    if (선물지수[j] > 선물지수[i]) {
                        선물수[j]++;
                    }
                }
            }
        }

        int 최대선물수 = 0;
        for (int 선물개수 : 선물수) {
            최대선물수 = Math.max(최대선물수, 선물개수);
        }

        return 최대선물수;
    }
}
