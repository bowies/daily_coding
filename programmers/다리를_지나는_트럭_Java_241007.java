package programmers;

import java.util.LinkedList;
import java.util.Queue;

class 다리를_지나는_트럭_Java_241007 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeightOnBridge = 0;
        int truckIndex = 0;

        // 다리 길이만큼 0으로 큐를 초기화 (빈 자리 표현)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++; // 시간 경과

            // 다리에서 트럭이 나가는 부분 (큐에서 제거)
            totalWeightOnBridge -= bridge.poll();

            // 대기 중인 트럭이 남아있다면 새로운 트럭이 다리에 올라갈 수 있는지 확인
            if (truckIndex < truck_weights.length) {
                if (totalWeightOnBridge + truck_weights[truckIndex] <= weight) {
                    // 트럭이 다리에 올라갈 수 있으면 큐에 추가
                    bridge.add(truck_weights[truckIndex]);
                    totalWeightOnBridge += truck_weights[truckIndex];
                    truckIndex++;
                } else {
                    bridge.add(0);
                }
            }
        }

        return time;
    }
}
