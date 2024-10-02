package programmers;

import java.util.*;

class 실패물_Java_241001 {
    public int[] solution(int N, int[] stages) {
        int[] 답안 = new int[N];
        int[] 스테이지별_플레이어수 = new int[N + 2];  // 각 스테이지에 머물고 있는 플레이어 수
        int 총_플레이어수 = stages.length;  // 전체 플레이어 수
        
        // 각 스테이지에 머물고 있는 플레이어 수 계산
        for (int 스테이지 : stages) {
            스테이지별_플레이어수[스테이지]++;
        }
        
        List<실패율> 실패율목록 = new ArrayList<>();
        int 도달한_플레이어수 = 총_플레이어수;

        // 각 스테이지에 대한 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (도달한_플레이어수 == 0) {
                실패율목록.add(new 실패율(i, 0));
            } else {
                double 실패율계산 = (double) 스테이지별_플레이어수[i] / 도달한_플레이어수;
                실패율목록.add(new 실패율(i, 실패율계산));
            }
            도달한_플레이어수 -= 스테이지별_플레이어수[i];
        }
        
        // 실패율을 기준으로 정렬, 실패율이 같으면 스테이지 번호가 작은 것이 우선
        Collections.sort(실패율목록, (a, b) -> {
            if (b.실패율값 == a.실패율값) {
                return a.스테이지번호 - b.스테이지번호;
            }
            return Double.compare(b.실패율값, a.실패율값);
        });
        
        for (int i = 0; i < N; i++) {
            답안[i] = 실패율목록.get(i).스테이지번호;
        }

        return 답안;
    }
}

class 실패율 {
    int 스테이지번호;
    double 실패율값;

    실패율(int 스테이지번호, double 실패율값) {
        this.스테이지번호 = 스테이지번호;
        this.실패율값 = 실패율값;
    }
}
