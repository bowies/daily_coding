package programmers;

import java.util.Arrays;

public class 기지국설치_230208 {
    
    public static void main(String[] args) {
        int n = 11;
        int [] stations = {4,11};
        int W = 1;

        System.out.println(solution(n, stations, W));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;

        //n = 아파트의 개수
        //stations = 아파트 번호 담긴 배열
        //W = 전파의 도달 범위

        //기지국 설치 개수 세기

        int 시작점 = 1;
        for(int i = 0; i< stations.length; i++){
            if(시작점 < stations[i] - w){
                answer += 기지국찾기(시작점, stations[i]-w-1, w);
            }
            시작점 = stations[i] + w + 1;
        }

        if(stations[stations.length - 1] + w < n){
            answer = answer + 기지국찾기(stations[stations.length -1] + w + 1, n, w);
        }


        return answer;
    }
    public static int 기지국찾기(int 시작점, int 끝점, int w){
        int answer = (끝점 - 시작점 + 1) / (2 * w  + 1);
        if((끝점 - 시작점 + 1) % (2 * w + 1) > 0) {
            answer++;
        }
        return answer;
    }
}
