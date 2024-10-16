package programmers;
import java.util.HashSet;
import java.util.Set;

class Summer_Winter_Coding_2018_241016 { 
    
    public int solution(String dirs) {
        int 현재x = 0, 현재y = 0;
        Set<String> 방문한길 = new HashSet<>();

        for (char 방향 : dirs.toCharArray()) {
            int 다음x = 현재x, 다음y = 현재y;
            
            switch (방향) {
                case 'U': 다음y++; break;
                case 'D': 다음y--; break;
                case 'R': 다음x++; break;
                case 'L': 다음x--; break;
            }
            
            if (다음x < -5 || 다음x > 5 || 다음y < -5 || 다음y > 5) continue;
            
            String 길1 = 현재x + "," + 현재y + "->" + 다음x + "," + 다음y;
            String 길2 = 다음x + "," + 다음y + "->" + 현재x + "," + 현재y;
            
            방문한길.add(길1);
            방문한길.add(길2);
            
            현재x = 다음x;
            현재y = 다음y;
        }

        return 방문한길.size() / 2;
    }
}
