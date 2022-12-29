package programmers;

import java.util.LinkedList;

public class 캐시_221229 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(cacheSize, cities));

    }
    public static int solution(int cacheSize, String[] cities) {
        //캐시 히트랑 캐시 미스를 구현하면 됨
        //LRU - 가장 오랫동안 참조하지 않은 페이지를 캐시에서 교체하는 것
        // cache hit일 경우 실행시간은 1이다.
        // cache miss일 경우 실행시간은 5이다.

        int answer = 0;
        String temp = null;
        if(cacheSize == 0 ){
            answer = cities.length * 5; //cache miss인 경우 실행시간은 5
            return answer;
        }

        LinkedList <String> queue = new LinkedList<>();

        for(int i = 0; i < cities.length; i++){
            temp = cities[i].toUpperCase(); //★ 이거 안해주면 ["Jeju", "Pangyo", "NewYork", "newyork"] 의 경우 통과를 못한다! Lower 해도 상관없음.
            if(queue.remove(temp)){
                //System.out.println("캐시 히트" + i);
                answer++; //cache hit인 경우는 +1
                queue.add(temp);
            }else{
                //System.out.println("캐시 미스" + i);
                answer = answer + 5; //cache miss
                if(queue.size() >= cacheSize){
                    queue.remove(0);
                }
                queue.add(temp);
            }
        }

        return answer;
    }
}
