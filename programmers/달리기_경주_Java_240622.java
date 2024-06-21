package programmers;

import java.util.HashMap;
import java.util.Map;

class 달리기_경주_Java_240622{
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>(); // 이름 | 순위

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String str : callings) {
            int 현재 = map.get(str);
            if (현재 > 0) {
                int 현재바로앞 = 현재 - 1;

                String 현재선수 = players[현재];
                String 바로앞선수 = players[현재바로앞];
                
                //순서 치환
                players[현재바로앞] = 현재선수;
                players[현재] = 바로앞선수;
                
                //map 순서 치환
                map.put(현재선수, 현재바로앞);
                map.put(바로앞선수, 현재);
            }
        }
        
        return players;
    }
}
