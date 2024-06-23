package programmers;

class 택배_배달과_수거하기_Java_240623 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        //베스트 솔루션!!

        long answer = 0;

        int 배달할택배수 = 0;
        int 수거할택배수 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int 이동횟수 = 0;

            배달할택배수 += deliveries[i]; //현재 집에서 배달할 택배
            수거할택배수 += pickups[i];

            while (배달할택배수 > 0 || 수거할택배수 > 0) {
                // 트럭이 운반할 수 있는 최대 상자 수(cap)만큼 처리
                배달할택배수 -= cap;
                수거할택배수 -= cap;
                이동횟수++;
            }

            answer += (i + 1) * 2 * 이동횟수; //현재 집에서 이동 거리 계산
        }

        return answer;
    }
}
