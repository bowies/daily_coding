package programmers;

import java.util.HashMap;

public class 위장_221228 {
    public static void main(String[] args) {
        String [][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int ans = solution(clothes);
        System.out.println("답 : " + ans);
    }
    public static int solution(String[][] clothes) {
        //옷이 많이 없는 스파이
        int answer = 1;
        HashMap <String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
            //getOrDefault 땡큐!
            //System.out.println(clothes[i][1] + " " + map.get(clothes[i][1]));
        }
        
        for(String key : map.keySet()){
            //System.out.println(map.get(key));
            //정답 * (현재값+1) -1  = 순서없이 중복 허용 하지 않는 경우 값을 구하는 법
            answer = answer * (map.get(key)+1);
            
        }


        
        return answer-1;
    }
}
