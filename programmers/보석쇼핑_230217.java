package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class 보석쇼핑_230217 {
    public static void main(String[] args) {
        //푸는중
        String [] 보석쓰 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(보석쓰));
    }

    public static int[] solution(String[] gems) {

        //보석을 여기서부터 여기까지 주세요 할 것임
        //보석 종류 다 찾아서
        //다 있으면 out

        int[] answer = new int[2];
        int len = gems.length;

        HashSet<String> set = new HashSet<>();

        for (String str : gems) {
            //d
            set.add(str);
        }


        int 범위 = Integer.MAX_VALUE;
        int 왼쪽 = 0;
        int 오른쪽 = 0;


        int start = 0;
        int end = 0;

        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            if (set.size() == map.size()) {
                //크기가 같으면 -> <<<< 해본다
                map.put(gems[왼쪽], map.get(gems[왼쪽])-1);
                if (map.get(gems[왼쪽]) == 0) {
                    map.remove(gems[왼쪽]);
                }
                왼쪽++;
            } else if (오른쪽 == len) {
                break;
            } else {
                // >>>> 로 간다 (set에 있는 애들 찾기)
                map.put(gems[오른쪽], map.getOrDefault(gems[오른쪽], 0) + 1);
                오른쪽++;
            }

            if (map.size() == set.size()) {
                if (오른쪽-왼쪽 < 범위){
                    범위 = 오른쪽-왼쪽;
                    start = 왼쪽+1;
                    end = 오른쪽;
                }
            }

        }

        answer[0] = start;
        answer[1] = end;

        return answer;
    }
}
